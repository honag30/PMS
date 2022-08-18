package fa.trainning.services;

import fa.trainning.daoi.DAOFactory;
import fa.trainning.daoi.EmployeeDAOI;
import fa.trainning.entities.Employee;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class EmployeeService implements AutoCloseable{
    private final EmployeeDAOI employeeDAO = DAOFactory.getNewEmployeeDAO();

    public boolean createEmployeeService(Employee employee)  throws SQLException, ParseException {
        return employeeDAO.createEmployee(employee);
    }
    public List<Employee> viewAllEmployeeService()  throws SQLException, ParseException {
        return employeeDAO.viewAllEmployee();
    }
    public List<Employee> searchEmployeeService(String key, int id)  throws SQLException, ParseException {
        return employeeDAO.searchEmployee(key, id);
    }

    public boolean editEmployeeService(Employee employee)  throws SQLException, ParseException {
        return employeeDAO.editEmployee(employee);
    }

    public boolean updateEmployeeService(Employee employee) throws SQLException, ParseException, ClassNotFoundException {
        return employeeDAO.updateEmployee(employee);
    }


    public boolean deleteEmployeeService(int id)  throws SQLException, ParseException {
        return employeeDAO.deleteEmployee(id);
    }

    public Employee getEmployeeByIdService(int id)  throws SQLException, ParseException{
        return employeeDAO.getEmployeeById(id);
    }

    public Employee getEmployeeByEmailService(String email)  throws SQLException, ParseException{
        return employeeDAO.getEmployeeByEmail(email);
    }

    public Employee checkLoginService(String account, String password) throws SQLException, ClassNotFoundException {
        return employeeDAO.checkLogin(account, password);
    }

    @Override
    public void close() throws Exception {

    }
}
