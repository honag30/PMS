package fa.trainning.dao;

import fa.trainning.connect.DBUtils;
import fa.trainning.daoi.BookingOfficeDAOI;
import fa.trainning.entities.BookingOffice;
import fa.trainning.utils.ErrorHandling;
import fa.trainning.utils.SQLCommand;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BookingOfficeDAO implements BookingOfficeDAOI {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet results = null;

    DBUtils dbhelper = DBUtils.getDBHelper();

    @Override
    public boolean createBookingOffice(BookingOffice bookingOffice) throws SQLException, ParseException {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.BOOK_OFFICE_QUERY_CREATE);

            preparedStatement.setString(1, bookingOffice.getOfficeName());
            preparedStatement.setLong(2, bookingOffice.getTripId());
            preparedStatement.setString(3, bookingOffice.getOfficePhone());
            preparedStatement.setString(4, bookingOffice.getOfficePlace());
            preparedStatement.setLong(5, bookingOffice.getOfficePrice());
            preparedStatement.setDate(6, bookingOffice.getStartContractDeadline());
            preparedStatement.setDate(7, bookingOffice.getEndContractDeadline());

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
    public List<BookingOffice> viewAllBookingOffice(){
        List<BookingOffice> bookingOffices = new ArrayList<>();
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.BOOKING_OFFICE_QUERY_GET_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int officeId = rs.getInt("officeId");
                String officeName = rs.getString("officeName");
                int tripId = rs.getInt("tripId");
                bookingOffices.add(new BookingOffice(officeId, officeName, tripId));
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
        return bookingOffices;
    }

    @Override
    public List<BookingOffice> searchBookingOffice(String key, int id) throws SQLException, ParseException {
        return null;
    }

    @Override
    public boolean editBookingOffice(BookingOffice bookingOffice) throws SQLException, ParseException {
        return false;
    }

    @Override
    public boolean deleteBookingOffice(int id) throws SQLException, ParseException {
        boolean rowDeleted = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.BOOKING_OFFICE_QUERY_DELETE_BY_ID);
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
    public BookingOffice getBookingOfficeById(int id) throws SQLException, ParseException {
        BookingOffice bookingOffice = null;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.BOOKING_OFFICE_QUERY_GET_BY_ID);
            preparedStatement.setInt(1, id);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                bookingOffice = new BookingOffice();
                bookingOffice.setOfficeId(id);
                bookingOffice.setOfficeName(results.getString("officeName"));
                bookingOffice.setTripId(results.getInt("tripId"));
                bookingOffice.setOfficePhone(results.getString("officePhone"));
                bookingOffice.setOfficePlace(results.getString("officePlace"));
                bookingOffice.setOfficePrice(results.getLong("officePrice"));
                bookingOffice.setStartContractDeadline(results.getDate("startContractDeadline"));
                bookingOffice.setEndContractDeadline(results.getDate("endContractDeadline"));
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
        return bookingOffice;
    }

    @Override
    public boolean updateBookingOffice(BookingOffice bookingOffice) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.BOOKING_OFFICE_QUERY_UPDATE);
            preparedStatement.setString(1, bookingOffice.getOfficeName());
            preparedStatement.setLong(2, bookingOffice.getTripId());
            preparedStatement.setString(3, bookingOffice.getOfficePhone());
            preparedStatement.setString(4, bookingOffice.getOfficePlace());
            preparedStatement.setLong(5, bookingOffice.getOfficePrice());
            preparedStatement.setDate(6, bookingOffice.getStartContractDeadline());
            preparedStatement.setDate(7, bookingOffice.getEndContractDeadline());
            preparedStatement.setLong(8, bookingOffice.getOfficeId());
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
}
