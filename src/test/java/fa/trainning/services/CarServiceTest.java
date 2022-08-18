package fa.trainning.services;


import fa.trainning.entities.Car;
import fa.trainning.services.CarService;

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

public class CarServiceTest {
	private CarService CarService;
	private List<Car> Cars;
	private List<Car> actualCars;

	@BeforeEach
	void setUp() {
		CarService = new CarService();
	}


	@Test
	void createCarService() throws SQLException, ParseException {
		Car Car1 = new Car("123-24","Black","Lambo","MX",4);
		boolean isCreated = CarService.createCarService(Car1);
		assertTrue(isCreated);
	}

	@Test
	void viewAllCarService() throws SQLException, ParseException {
		Cars = new ArrayList<>();

		Cars.add(new Car("123-23","White","Bugatti","La Voatio Noire",2));
		
		// Get From Database.
		actualCars = CarService.viewAllCarService();

		for (int i = 0; i < Cars.size(); i++) {
			assertEquals(Cars.get(i).getLicensePlate(), actualCars.get(i).getLicensePlate());
			assertEquals(Cars.get(i).getCarType(), actualCars.get(i).getCarType());
			assertEquals(Cars.get(i).getCompany(), actualCars.get(i).getCompany());
			assertEquals(Cars.get(i).getParkId(), actualCars.get(i).getParkId());
			assertEquals(Cars.get(i).getCarColor(), actualCars.get(i).getCarColor());
			
		}
	}
	
	@Test
	void getCarByIdService() throws SQLException, ParseException {
		Car existingCar = CarService.getCarByLicensePlateService("123-23");
		assertNotNull(existingCar); // Existed 
		Car notExistingCar = CarService.getCarByLicensePlateService("123-27");
		assertNull(notExistingCar); // Not existed
	}

	@Test
	void updateCarService() throws ParseException, SQLException, ClassNotFoundException {
		// Perform on record have license existed
		assertTrue(CarService.updateCarService(new Car("123-23","Black","BMX","BMX",4)));

		// Perform on record have license not existed
		assertFalse(CarService.updateCarService(new Car("123-24","Black","Lambo","MX",4)));
	}

	@Test
	void deleteCarService() throws SQLException, ParseException {
		assertTrue(CarService.deleteCarService("123-23")); // Existed
		assertFalse(CarService.deleteCarService("123-24")); // Not existed
	}

	
}
