package fa.trainning.dao;

import fa.trainning.connect.DBUtils;
import fa.trainning.daoi.EmployeeDAOI;
import fa.trainning.entities.Employee;
import fa.trainning.utils.ErrorHandling;
import fa.trainning.utils.SQLCommand;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements EmployeeDAOI {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet results = null;

    DBUtils dbhelper = DBUtils.getDBHelper();

    @Override
    public Employee checkLogin (String email, String password){
        Employee employee = null;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEE_QUERY_LOGIN);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                employee = new Employee();
                employee.setEmployeeId (results.getInt("employeeId"));
                employee.setAccount (results.getString("account"));
                employee.setEmployeeEmail (results.getString("employeeEmail"));
                employee.setPassword (results.getString("password"));
                employee.setRole (results.getString("role"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                ErrorHandling.printSQLException(e);
            }
        }
        return employee;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEE_QUERY_UPDATE);

            preparedStatement.setString(1, employee.getAccount());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.setString(3, employee.getEmployeeAddress());
            preparedStatement.setDate(4, employee.getEmployeeBirthDate());
            preparedStatement.setString(5, employee.getEmployeeEmail());
            preparedStatement.setString(6, employee.getEmployeeName());
            preparedStatement.setString(7, employee.getEmployeePhone());
            preparedStatement.setString(8, employee.getPassword());
            preparedStatement.setString(9, employee.getSex().name());
            preparedStatement.setInt(10, employee.getEmployeeId());
            check = preparedStatement.executeUpdate() > 0;

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    @Override
    public boolean createEmployee(Employee employee) {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEE_QUERY_CREATE);
            preparedStatement.setString(1, employee.getAccount());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.setString(3, employee.getEmployeeAddress());
            preparedStatement.setDate(4, employee.getEmployeeBirthDate());
            preparedStatement.setString(5, employee.getEmployeeEmail());
            preparedStatement.setString(6, employee.getEmployeeName());
            preparedStatement.setString(7, employee.getEmployeePhone());
            preparedStatement.setString(8, employee.getPassword());
            preparedStatement.setString(9, employee.getSex().name());

            check = preparedStatement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                ErrorHandling.printSQLException(e);
            }
        }
        return check;
    }

    @Override
    public List<Employee> viewAllEmployee() throws SQLException, ParseException {
        List<Employee> employees = new ArrayList<>();
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEE_QUERY_GET_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("employeeId");
                Date employeeBirthDate = rs.getDate("employeeBirthdate");
                String employeeAddress = rs.getString("employeeAddress");
                String employeeName = rs.getString("employeeName");
                String employeePhone = rs.getString("employeePhone");
                String department = rs.getString("department");
                employees.add(new Employee(id, department, employeeAddress, employeeBirthDate,employeePhone, employeeName ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                ErrorHandling.printSQLException(e);
            }
        }
        return employees;
    }

    @Override
    public List<Employee> searchEmployee(String key, int id) throws SQLException, ParseException {
        //TODO: Write function here.
        return null;
    }

    @Override
    public boolean editEmployee(Employee employee) throws SQLException, ParseException {
        //TODO: Write function here.
        return false;
    }

    @Override
    public boolean deleteEmployee(int id){
        boolean rowDeleted = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEE_QUERY_DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                ErrorHandling.printSQLException(e);
            }
        }
        return rowDeleted;
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        Employee employee = null;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEE_QUERY_GET_BY_ID);
            preparedStatement.setInt(1, id);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                employee = new Employee();
                employee.setEmployeeId(results.getInt("employeeId"));
                employee.setEmployeeName(results.getString("employeeName"));
                employee.setEmployeePhone(results.getString("employeePhone"));
                employee.setEmployeeBirthDate(results.getDate("employeeBirthdate"));
                if (results.getString("sex").equals("F")){
                    employee.setSex(Employee.Gender.F);
                } else if (results.getString("sex").equals("M")){
                    employee.setSex(Employee.Gender.M);
                }else {
                    throw new Exception();
                }
                employee.setEmployeeAddress(results.getString("employeeAddress"));
                employee.setEmployeeEmail(results.getString("employeeEmail"));
                employee.setAccount(results.getString("account"));
                employee.setPassword(results.getString("password"));
                employee.setDepartment(results.getString("department"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByEmail(String email) throws SQLException {
        Employee employee = null;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEE_QUERY_GET_BY_EMAIL);
            preparedStatement.setString(1, email);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                employee = new Employee();
                employee.setEmployeeName(results.getString("employeeName"));
                employee.setEmployeePhone(results.getString("employeePhone"));
                employee.setEmployeeBirthDate(results.getDate("employeeBirthdate"));
                if (results.getString("sex").equals("F")){
                    employee.setSex(Employee.Gender.F);
                } else if (results.getString("sex").equals("M")){
                    employee.setSex(Employee.Gender.M);
                }else {
                    throw new Exception();
                }
                employee.setEmployeeAddress(results.getString("employeeAddress"));
                employee.setEmployeeEmail(results.getString("employeeEmail"));
                employee.setAccount(results.getString("account"));
                employee.setDepartment(results.getString("department"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }
}
