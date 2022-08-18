package fa.trainning.services;


import fa.trainning.entities.Ticket;
import fa.trainning.services.TicketService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

public class TicketServiceTest {
	private TicketService TicketService;
	private List<Ticket> Tickets;
	private List<Ticket> actualTickets;

	@BeforeEach
	void setUp() {
		TicketService = new TicketService();
	}
	
	

	@Test
	void createTicketService() throws SQLException, ParseException {
		Ticket Ticket1 = new Ticket(Time.valueOf("2021-04-08"),"tung","123-21",1);
		boolean isCreated = TicketService.createTicketService(Ticket1);
		assertTrue(isCreated);
	}

	@Test
	void viewAllTicketService() throws SQLException, ParseException {
		Tickets = new ArrayList<>();

		Tickets.add(new Ticket(1,Time.valueOf("12:30:00"),"tung","123-21",1));
		
		// Get From Database.
		actualTickets = TicketService.viewAllTicketService();

		for (int i = 0; i < Tickets.size(); i++) {
			assertEquals(Tickets.get(i).getBookingTime(), actualTickets.get(i).getBookingTime());
			assertEquals(Tickets.get(i).getCustomerName(), actualTickets.get(i).getCustomerName());
			assertEquals(Tickets.get(i).getLicensePlate(), actualTickets.get(i).getLicensePlate());
			assertEquals(Tickets.get(i).getTicketId(), actualTickets.get(i).getTicketId());
			assertEquals(Tickets.get(i).getTripId(), actualTickets.get(i).getTripId());
			
		}
	}
	
	@Test
	void getTicketByIdService() throws SQLException, ParseException {
		Ticket existingTicket = TicketService.getTicketByIdService(1);
		assertNotNull(existingTicket); // Existed 
		Ticket notExistingTicket = TicketService.getTicketByIdService(2);
		assertNull(notExistingTicket); // Not existed
	}

	@Test
	void updateTicketService() throws ParseException, SQLException, ClassNotFoundException {
		// Perform on record have license existed
		assertTrue(TicketService.updateTicketService(new Ticket(1,Time.valueOf("2021-04-08"),"tung","123-21",1)));

		// Perform on record have license not existed
		assertFalse(TicketService.updateTicketService(new Ticket(2,Time.valueOf("2021-04-08"),"tung","123-21",1)));
	}

	@Test
	void deleteTicketService() throws SQLException, ParseException {
		assertTrue(TicketService.deleteTicketService(1)); // Existed
		assertFalse(TicketService.deleteTicketService(2)); // Not existed
	}

	
}
