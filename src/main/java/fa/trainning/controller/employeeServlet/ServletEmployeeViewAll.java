package fa.trainning.controller.employeeServlet;

import fa.trainning.entities.Employee;
import fa.trainning.services.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "ServletEmployeeViewAll", value = "/ServletEmployeeViewAll")
public class ServletEmployeeViewAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (EmployeeService employeeService = new EmployeeService()) {
            List<Employee> listEmployee = employeeService.viewAllEmployeeService();
            request.setAttribute("listEmployee", listEmployee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/employee-views/employee-view-all.jsp");
            dispatcher.forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
