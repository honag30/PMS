package fa.trainning.services;


import fa.trainning.entities.Employee;
import fa.trainning.services.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
 * TEST JUST VALID DURING PROCESS OF PROJECT. NOT VALID FOR FINAL PRODUCT.
 * (Run the test might not run probably because test against DB)
 *
 * Run The SQL file before testing to make sure data is valid in this test.
 * Test run once only. Because it perform on Database.
 * EX: If your delete a record --> it did not exist anymore --> run again it will not perform expected.
 *
 */

public class EmployeeServiceTest {
	private EmployeeService EmployeeService;
	private List<Employee> Employees;
	private List<Employee> actualEmployees;

	@BeforeEach
	void setUp() {
		EmployeeService = new EmployeeService();
	}

	@Test
	void createEmployeeService() throws SQLException, ParseException {
		Employee Employee1 = new Employee();
		boolean isCreated = EmployeeService.createEmployeeService(Employee1);
		assertTrue(isCreated);
	}

	@Test
	void viewAllEmployeeService() throws SQLException, ParseException {
		Employees = new ArrayList<>();
		Employees.add(new Employee());
		Employees.add(new Employee());
		
		

		// Get From Database.
		actualEmployees = EmployeeService.viewAllEmployeeService();

		for (int i = 0; i < Employees.size(); i++) {
			assertEquals(Employees.get(i).getAccount(), actualEmployees.get(i).getAccount());
			assertEquals(Employees.get(i).getDepartment(), actualEmployees.get(i).getDepartment());
			assertEquals(Employees.get(i).getEmployeeAddress(), actualEmployees.get(i).getEmployeeAddress());
			assertEquals(Employees.get(i).getEmployeeBirthDate(), actualEmployees.get(i).getEmployeeBirthDate());
			assertEquals(Employees.get(i).getEmployeeEmail(), actualEmployees.get(i).getEmployeeEmail());
			assertEquals(Employees.get(i).getEmployeeId(), actualEmployees.get(i).getEmployeeId());
			assertEquals(Employees.get(i).getEmployeeName(), actualEmployees.get(i).getEmployeeName());
			assertEquals(Employees.get(i).getEmployeePhone(), actualEmployees.get(i).getEmployeePhone());
			assertEquals(Employees.get(i).getPassword(), actualEmployees.get(i).getPassword());
			assertEquals(Employees.get(i).getSex(), actualEmployees.get(i).getSex());
		}
	}

	@Test
	void updateEmployeeService() throws ParseException, SQLException, ClassNotFoundException {
		// Perform on record have id existed
		assertTrue(EmployeeService.updateEmployeeService(new Employee()));

		// Perform on record have id not exist record
		assertFalse(EmployeeService.updateEmployeeService(new Employee()));
	}

	@Test
	void deleteEmployeeService() throws SQLException, ParseException {
		assertTrue(EmployeeService.deleteEmployeeService(4)); // Existed ID
		assertFalse(EmployeeService.deleteEmployeeService(14)); // Not existed ID
	}

	@Test
	void getEmployeeByIdService() throws SQLException, ParseException {
		Employee existingEmployee = EmployeeService.getEmployeeByIdService(1);
		assertNotNull(existingEmployee); // Existed ID
		Employee notExistingEmployee = EmployeeService.getEmployeeByIdService(14);
		assertNull(notExistingEmployee);// Unexisted id
	}
}
