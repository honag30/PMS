package fa.trainning.services;


import fa.trainning.entities.Trip;
import fa.trainning.services.TripService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
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

public class TripServiceTest {
	private TripService TripService;
	private List<Trip> Trips;
	private List<Trip> actualTrips;

	@BeforeEach
	void setUp() {
		TripService = new TripService();
	}

	@Test
	void createTripService() throws SQLException, ParseException {
		Trip Trip1 = new Trip("Sport", Date.valueOf("2021-03-26"), Time.valueOf("12:30:00"), "Haiphong", "Do Long Q", 50);
		boolean isCreated = TripService.createTripService(Trip1);
		assertTrue(isCreated);
	}

	@Test
	void viewAllTripService() throws SQLException, ParseException {
		Trips = new ArrayList<>();

		Trips.add(new Trip(1, "Sport", Date.valueOf("2021-03-26"), Time.valueOf("12:30:00"), "Haiphong", "Do Long Q", 50));
		
		// Get From Database.
		actualTrips = TripService.viewAllTripService();

		for (int i = 0; i < Trips.size(); i++) {
			assertEquals(Trips.get(i).getCarType(), actualTrips.get(i).getCarType());
			assertEquals(Trips.get(i).getDepartureDate(), actualTrips.get(i).getDepartureDate());
			assertEquals(Trips.get(i).getDepartureTime(), actualTrips.get(i).getDepartureTime());
			assertEquals(Trips.get(i).getDestination(), actualTrips.get(i).getDestination());
			assertEquals(Trips.get(i).getDriver(), actualTrips.get(i).getDriver());
			assertEquals(Trips.get(i).getMaximumOnlineTicketNumber(), actualTrips.get(i).getMaximumOnlineTicketNumber());
			
		}
	}
	
	@Test
	void getTripByIdService() throws SQLException, ParseException {
		Trip existingTrip = TripService.getTripByIdService(3);
		assertNotNull(existingTrip); // Existed 
		Trip notExistingTrip = TripService.getTripByIdService(17);
		assertNull(notExistingTrip); // Not existed
	}

	@Test
	void updateTripService() throws ParseException, SQLException, ClassNotFoundException {
		// Perform on record have license existed
		assertTrue(TripService.updateTripService(new Trip(3, "Sport", Date.valueOf("2021-03-26"), Time.valueOf("12:30:00"), "Haiphong", "Do Long Q", 50)));

		// Perform on record have license not existed
		assertFalse(TripService.updateTripService(new Trip(17, "Sport", Date.valueOf("2021-03-26"), Time.valueOf("12:30:00"), "Haiphong", "Do Long Q", 50)));
	}

	@Test
	void deleteTripService() throws SQLException, ParseException {
		assertTrue(TripService.deleteTripService(1)); // Existed
		assertFalse(TripService.deleteTripService(17)); // Not existed
	}

	
}
