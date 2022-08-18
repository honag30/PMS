package fa.trainning.controller.employeeServlet;

import fa.trainning.entities.Employee;
import fa.trainning.services.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet(name = "ServletEmployeeGetById", value = "/ServletEmployeeGetById")
public class ServletEmployeeGetById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (EmployeeService employeeService = new EmployeeService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = employeeService.getEmployeeByIdService(id);
            request.setAttribute("employee", employee);

            RequestDispatcher dispatcher = request.getRequestDispatcher("src/main/webapp/assets/views/employee-views/editEmployee.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
