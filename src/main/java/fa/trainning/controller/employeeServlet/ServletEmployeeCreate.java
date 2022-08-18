package fa.trainning.controller.employeeServlet;

import fa.trainning.entities.Employee;
import fa.trainning.services.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "ServletEmployeeCreate", value = "/ServletEmployeeCreate")
public class ServletEmployeeCreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (EmployeeService employeeService = new EmployeeService()) {

            String employeeName = request.getParameter("employeeName");
            String employeePhone = request.getParameter("employeePhone");
            Date employeeBirthDate = Date.valueOf(request.getParameter("employeeBirthDate"));
            String gender = request.getParameter("gender");
            String employeeAddress = request.getParameter("employeeAddress");
            String employeeEmail = request.getParameter("employeeEmail");
            String account = request.getParameter("account");
            String password = request.getParameter("password");
            String department = request.getParameter("department");

            Employee.Gender employeeGender;

            if (gender.equals("F")){
                employeeGender = Employee.Gender.F;
            } else if (gender.equals("M")){
                employeeGender = Employee.Gender.M;
            }else {
                throw new Exception();
            }

            Employee checkExistedEmployee = employeeService.getEmployeeByEmailService(employeeEmail);
            if (checkExistedEmployee != null){
                request.setAttribute("message", "Email '"+employeeEmail+"' already existed!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/employee-views/employee-form.jsp");
                dispatcher.forward(request, response);
            } else {
                Employee newEmployee = new Employee(account, department, employeeAddress, employeeBirthDate, employeeEmail, employeeName, employeePhone, password, employeeGender );
                boolean created = employeeService.createEmployeeService(newEmployee);

                if (created){
                    request.setAttribute("successMessage", "Create Success!");
                } else {
                    request.setAttribute("warningMessage", "Create Fail!");
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletEmployeeViewAll");
                dispatcher.forward(request, response);
            }

            } catch (Exception e) {
                e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
