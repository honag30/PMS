package fa.trainning.services;

import fa.trainning.daoi.DAOFactory;
import fa.trainning.daoi.BookingOfficeDAOI;
import fa.trainning.entities.BookingOffice;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class BookingOfficeService implements AutoCloseable{
    private final BookingOfficeDAOI bookingOfficeDAO = DAOFactory.getNewBookingOfficeDAO();

    public boolean createBookingOfficeService(BookingOffice bookingOffice)  throws SQLException, ParseException {
        return bookingOfficeDAO.createBookingOffice(bookingOffice);
    }
    public List<BookingOffice> viewAllBookingOfficeService()  throws SQLException, ParseException {
        return bookingOfficeDAO.viewAllBookingOffice();
    }
    public List<BookingOffice> searchBookingOfficeService(String key, int id)  throws SQLException, ParseException {
        return bookingOfficeDAO.searchBookingOffice(key, id);
    }

    public boolean editBookingOfficeService(BookingOffice bookingOffice)  throws SQLException, ParseException {
        return bookingOfficeDAO.editBookingOffice(bookingOffice);
    }

    public boolean updateBookingOfficeService(BookingOffice bookingOffice) throws SQLException, ParseException, ClassNotFoundException {
        return bookingOfficeDAO.updateBookingOffice(bookingOffice);
    }


    public boolean deleteBookingOfficeService(int id)  throws SQLException, ParseException {
        return bookingOfficeDAO.deleteBookingOffice(id);
    }

    public BookingOffice getBookingOfficeByIdService(int id)  throws SQLException, ParseException{
        return bookingOfficeDAO.getBookingOfficeById(id);
    }

    @Override
    public void close() throws Exception {

    }
}
