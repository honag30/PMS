package fa.trainning.dao;

import fa.trainning.connect.DBUtils;
import fa.trainning.daoi.TicketDAOI;
import fa.trainning.entities.Ticket;
import fa.trainning.entities.Trip;
import fa.trainning.utils.ErrorHandling;
import fa.trainning.utils.SQLCommand;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements TicketDAOI {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet results = null;

    DBUtils dbhelper = DBUtils.getDBHelper();

    @Override
    public boolean createTicket(Ticket ticket) throws SQLException, ParseException {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TICKET_QUERY_CREATE);

            preparedStatement.setTime(1, ticket.getBookingTime());
            preparedStatement.setString(2, ticket.getCustomerName());
            preparedStatement.setString(3, ticket.getLicensePlate());
            preparedStatement.setLong(4, ticket.getTripId());

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
    public List<Ticket> viewAllTicket() throws SQLException, ParseException {
        List<Ticket> tickets = new ArrayList<>();
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TICKET_QUERY_GET_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long ticketId = rs.getLong("ticketId");
                Time bookTime = rs.getTime("bookTime");
                String customerName = rs.getString("customerName");
                String licensePlate = rs.getString("licensePlate");
                long tripId = rs.getLong("tripId");

                tickets.add(new Ticket(ticketId, bookTime, customerName, licensePlate, tripId));
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
        return tickets;
    }

    @Override
    public List<Ticket> searchTicket(String key, int id) throws SQLException, ParseException {
        return null;
    }

    @Override
    public boolean editTicket(Ticket ticket) throws SQLException, ParseException {
        return false;
    }

    @Override
    public boolean deleteTicket(int id) throws SQLException, ParseException {
        boolean rowDeleted = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TICKET_QUERY_DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
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
        return rowDeleted;
    }

    @Override
    public Ticket getTicketById(long id) throws SQLException, ParseException {
        Ticket ticket = null;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TICKET_QUERY_GET_BY_ID);
            preparedStatement.setLong(1, id);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                ticket = new Ticket();
                ticket.setTicketId(id);
                ticket.setBookingTime(results.getTime("bookTime"));
                ticket.setCustomerName(results.getString("customerName"));
                ticket.setLicensePlate(results.getString("licensePlate"));
                ticket.setTripId(results.getLong("tripId"));
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
        return ticket;
    }

    @Override
    public Ticket getTicketByName(String name) throws SQLException, ParseException {
        return null;
    }

    @Override
    public boolean updateTicket(Ticket ticket) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TICKET_QUERY_UPDATE);
            preparedStatement.setTime(1, ticket.getBookingTime());
            preparedStatement.setString(2, ticket.getCustomerName());
            preparedStatement.setString(3, ticket.getLicensePlate());
            preparedStatement.setLong(4, ticket.getTripId());
            preparedStatement.setLong(5, ticket.getTicketId());
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
    public long getNumberOfBookedTicket(long id) {
        long numberOfBookedTicket = 0;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TRIP_QUERY_GET_BOOKED_TICKET);
            preparedStatement.setLong(1, id);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                numberOfBookedTicket = results.getLong("bookedTicketNumber");
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
        return numberOfBookedTicket;
    }
}
