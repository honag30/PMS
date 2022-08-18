package fa.trainning.services;


import fa.trainning.entities.ParkingLot;
import fa.trainning.services.ParkingLotService;

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

public class ParkingLotServiceTest {
	private ParkingLotService parkingLotService;
	private List<ParkingLot> ParkingLots;
	private List<ParkingLot> actualParkingLots;

	@BeforeEach
	void setUp() {
		parkingLotService = new ParkingLotService();
	}

	@Test
	void createParkingLotService() throws SQLException, ParseException {
		ParkingLot ParkingLot1 = new ParkingLot(100,"bai so 1","Ha Noi",123);
		boolean isCreated = parkingLotService.createParkingLotService(ParkingLot1);
		assertTrue(isCreated);
	}

	@Test
	void viewAllParkingLotService() throws SQLException, ParseException {
		ParkingLots = new ArrayList<>();
		ParkingLots.add(new ParkingLot(2,104,"as11","Ha Noi",12,"Blank"));
		ParkingLots.add(new ParkingLot(4,55,"ggggg","Ha Noi",111,"Blank"));

		// Get From Database.
		actualParkingLots = parkingLotService.viewAllParkingLotService();

		for (int i = 0; i < ParkingLots.size(); i++) {
			assertEquals(ParkingLots.get(i).getParkId(), actualParkingLots.get(i).getParkId());
			assertEquals(ParkingLots.get(i).getParkName(), actualParkingLots.get(i).getParkName());
			assertEquals(ParkingLots.get(i).getParkArea(), actualParkingLots.get(i).getParkArea());
			assertEquals(ParkingLots.get(i).getParkPrice(), actualParkingLots.get(i).getParkPrice());
			assertEquals(ParkingLots.get(i).getParkStatus(), actualParkingLots.get(i).getParkStatus());
			assertEquals(ParkingLots.get(i).getParkPlace(), actualParkingLots.get(i).getParkPlace());
		}
	}

	@Test
	void updateParkingLotService() throws ParseException, SQLException, ClassNotFoundException {
		// Perform on record have id = 2
		assertTrue(parkingLotService.updateParkingLotService(new ParkingLot(2,104,"as11","Ha Noi",12,"Blank")));

		// Perform on record have id = 1 (not exist record)
		assertFalse(parkingLotService.updateParkingLotService(new ParkingLot(1,104,"as12","Ha Noi",12,"Blank")));
	}

	@Test
	void deleteParkingLotService() throws SQLException, ParseException {
		assertTrue(parkingLotService.deleteParkingLotService(13)); // Existed ID
		assertFalse(parkingLotService.deleteParkingLotService(11)); // Not existed ID
	}

	@Test
	void getParkingLotByIdService() throws SQLException, ParseException {
		ParkingLot existingParkingLot = parkingLotService.getParkingLotByIdService(2);
		assertNotNull(existingParkingLot); // Existed ID
		ParkingLot notExistingParkingLot = parkingLotService.getParkingLotByIdService(3);
		assertNull(notExistingParkingLot);
	}
}
