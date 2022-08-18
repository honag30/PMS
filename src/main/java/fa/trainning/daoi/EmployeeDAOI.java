package fa.trainning.daoi;

import fa.trainning.entities.Employee;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface EmployeeDAOI {
    boolean createEmployee(Employee employee) throws SQLException, ParseException;
    List<Employee> viewAllEmployee() throws SQLException, ParseException;
    List<Employee> searchEmployee(String key, int id) throws SQLException, ParseException;
    boolean editEmployee(Employee employee) throws SQLException, ParseException;
    boolean deleteEmployee(int id) throws SQLException, ParseException;
    Employee getEmployeeById(int id) throws SQLException, ParseException;
    Employee getEmployeeByEmail(String email) throws SQLException, ParseException;
    Employee checkLogin(String email, String password) throws SQLException, ClassNotFoundException;
    boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;
}
