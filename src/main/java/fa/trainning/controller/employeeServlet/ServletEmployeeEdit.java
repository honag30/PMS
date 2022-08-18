package fa.trainning.controller.employeeServlet;

import fa.trainning.entities.Employee;
import fa.trainning.services.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.FileStore;

@WebServlet(name = "ServletEmployeeEdit", value = "/ServletEmployeeEdit")
public class ServletEmployeeEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (EmployeeService employeeService = new EmployeeService()) {
            int id = Integer.parseInt(request.getParameter("id"));

            HttpSession session = request.getSession(false);
            String message = (String)session.getAttribute("updateMessage");
            if (message != null){
                request.setAttribute("message", message);
                session.removeAttribute("updateMessage");
            }

            Employee existingEmployee = employeeService.getEmployeeByIdService(id);
            request.setAttribute("existingEmployee", existingEmployee);

            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/employee-views/employee-form.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
