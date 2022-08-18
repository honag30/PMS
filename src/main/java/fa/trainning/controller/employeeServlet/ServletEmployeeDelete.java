package fa.trainning.controller.employeeServlet;

import fa.trainning.entities.Employee;
import fa.trainning.services.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet(name = "ServletEmployeeDelete", value = "/ServletEmployeeDelete")
public class ServletEmployeeDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (EmployeeService employeeService = new EmployeeService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean deleted = employeeService.deleteEmployeeService(id);
            if (deleted){
                request.setAttribute("warningMessage", "Delete Success!");
            } else {
                request.setAttribute("warningMessage", "Delete Fail!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletEmployeeViewAll");
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
