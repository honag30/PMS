package fa.trainning.services;

import fa.trainning.entities.BookingOffice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
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

class BookingOfficeServiceTest {

    private BookingOfficeService bookingOfficeService;
    private List<BookingOffice> bookingOffices;
    private List<BookingOffice> actualBookingOffices;

    @BeforeEach
    void setUp(){
        bookingOfficeService = new BookingOfficeService();
    }

    @Test
    void createBookingOfficeService() throws SQLException, ParseException {
        BookingOffice bookingOffice1 = new BookingOffice(Date.valueOf("2022-05-04"), "Office 1", "0988123712", "Hanoi", 4000, Date.valueOf("2023-05-04"), 1);
        boolean isCreated = bookingOfficeService.createBookingOfficeService(bookingOffice1);
        assertTrue(isCreated);
    }

    @Test
    void viewAllBookingOfficeService() throws SQLException, ParseException {
        bookingOffices = new ArrayList<>();
        bookingOffices.add(new BookingOffice(1, "Nhanh nhu phi", 3));
        bookingOffices.add(new BookingOffice(2, "Nhanh nhu bay", 2));
        bookingOffices.add(new BookingOffice(3, "Nhanh nhu gio", 1));

        //Get From Database.
        actualBookingOffices = bookingOfficeService.viewAllBookingOfficeService();

        for(int i = 0; i < bookingOffices.size(); i++) {
            assertEquals(bookingOffices.get(i).getOfficeId(), actualBookingOffices.get(i).getOfficeId());
            assertEquals(bookingOffices.get(i).getOfficeName(), actualBookingOffices.get(i).getOfficeName());
            assertEquals(bookingOffices.get(i).getTripId(), actualBookingOffices.get(i).getTripId());
        }
    }

    @Test
    void updateBookingOfficeService() throws ParseException, SQLException, ClassNotFoundException {
        //Perform on record have id = 4
        assertTrue(bookingOfficeService.updateBookingOfficeService(new BookingOffice(4, Date.valueOf("2014-12-12"), "Office1", "0984727427", "Hanoi", 5000, Date.valueOf("2013-12-12"),2)));

        //Perform on record have id = 100 (not exist record)
        assertFalse(bookingOfficeService.updateBookingOfficeService(new BookingOffice(100,Date.valueOf("2014-12-12"), "NonExistedOffice", "0984727427", "Hanoi", 5000, Date.valueOf("2013-12-12"),100)));
    }

    @Test
    void deleteBookingOfficeService() throws SQLException, ParseException {
        assertTrue(bookingOfficeService.deleteBookingOfficeService(1)); // Existed ID
        assertFalse(bookingOfficeService.deleteBookingOfficeService(100)); // Not existed ID
    }

    @Test
    void getBookingOfficeByIdService() throws SQLException, ParseException {
        BookingOffice existingBookingOffice = bookingOfficeService.getBookingOfficeByIdService(1);
        assertNotNull(existingBookingOffice); // Existed ID
        BookingOffice notExistingBookingOffice = bookingOfficeService.getBookingOfficeByIdService(100);
        assertNull(notExistingBookingOffice);
    }
}