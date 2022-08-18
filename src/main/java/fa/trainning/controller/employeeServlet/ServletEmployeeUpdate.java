package fa.trainning.controller.employeeServlet;

import fa.trainning.entities.Employee;
import fa.trainning.services.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;

@WebServlet(name = "ServletEmployeeUpdate", value = "/ServletEmployeeUpdate")
public class ServletEmployeeUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (EmployeeService employeeService = new EmployeeService()) {
            request.removeAttribute("updateSuccess");

            int id = Integer.parseInt(request.getParameter("id"));

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

            Employee newEmployee = new Employee(id, account, department, employeeAddress, employeeBirthDate, employeeEmail, employeeName, employeePhone, password, employeeGender );
            boolean updated = false;
            Employee checkExistedEmployee = employeeService.getEmployeeByEmailService(newEmployee.getEmployeeEmail());
            try {
                updated = employeeService.updateEmployeeService(newEmployee);
                if (updated){
                    request.setAttribute("successMessage", "Update Success!");
                } else {
                    request.setAttribute("warningMessage", "Update Fail!");
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletEmployeeViewAll");
                dispatcher.forward(request, response);
            }catch (Exception e){
                if (checkExistedEmployee != null){
                    HttpSession session = request.getSession(false);
                    session.setAttribute("updateMessage", "Email '"+employeeEmail+"' already existed!");
                    response.sendRedirect(request.getContextPath()+"/ServletEmployeeEdit?id=" + newEmployee.getEmployeeId());
                } else {
                    if (updated){
                        request.setAttribute("successMessage", "Update Success!");
                    } else {
                        request.setAttribute("warningMessage", "Update Fail!");
                    }
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletEmployeeViewAll");
                    dispatcher.forward(request, response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
