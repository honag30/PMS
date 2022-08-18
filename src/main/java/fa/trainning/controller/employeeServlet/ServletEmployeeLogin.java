package fa.trainning.controller.employeeServlet;

import fa.trainning.entities.Employee;
import fa.trainning.services.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletEmployeeLogin", value = "/ServletEmployeeLogin")
public class ServletEmployeeLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && (session.getAttribute("staff") != null || session.getAttribute("admin") != null)) {
            response.sendRedirect("ServletEmployeeViewAll");
        } else {
            request.getRequestDispatcher("assets/views/authentication/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean status = true;

        request.removeAttribute("message");
        if (email.trim().equals("")) {
            status = false;
        }
        if (password.trim().equals("")) {
            status = false;
        }

        if (!status) {
            request.setAttribute("page", "login");
            request.setAttribute("message", "Re enter Email & password.");
            request.getRequestDispatcher("assets/views/authentication/login.jsp").forward(request, response);
        } else {
            String destPage;
            EmployeeService employeeService = new EmployeeService();
            try {
                Employee employee = employeeService.checkLoginService(email, password);
                destPage = "assets/views/authentication/login.jsp";
                if (employee != null) {
                    String role = employee.getRole();
                    if (role.equals("admin")) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("admin", employee);
                        destPage = "/ServletEmployeeViewAll";
                        session.setMaxInactiveInterval(1800);
                    } else if (role.equals("staff")) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("staff", employee);
                        destPage = "/ServletBookingOfficeViewAll";
                    } else {
                        String message = "This account not have permission";
                        request.setAttribute("message", message);
                    }
                } else {
                    String message = "Invalid email/password";
                    request.setAttribute("message", message);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                throw new ServletException(ex);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        }
    }
}