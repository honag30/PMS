package fa.trainning.daoi;

import fa.trainning.entities.BookingOffice;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface BookingOfficeDAOI {
    boolean createBookingOffice(BookingOffice bookingOffice) throws SQLException, ParseException;
    List<BookingOffice> viewAllBookingOffice() throws SQLException, ParseException;
    List<BookingOffice> searchBookingOffice(String key, int id) throws SQLException, ParseException;
    boolean editBookingOffice(BookingOffice bookingOffice) throws SQLException, ParseException;
    boolean deleteBookingOffice(int id) throws SQLException, ParseException;
    BookingOffice getBookingOfficeById(int id) throws SQLException, ParseException;
    boolean updateBookingOffice(BookingOffice bookingOffice) throws SQLException, ClassNotFoundException;
}
