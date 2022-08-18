package fa.trainning.dao;

import fa.trainning.connect.DBUtils;
import fa.trainning.daoi.TripDAOI;
import fa.trainning.entities.Trip;
import fa.trainning.utils.ErrorHandling;
import fa.trainning.utils.SQLCommand;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TripDAO implements TripDAOI {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet results = null;

    DBUtils dbhelper = DBUtils.getDBHelper();

    @Override
    public boolean createTrip(Trip trip) throws SQLException, ParseException {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TRIP_QUERY_CREATE);

            preparedStatement.setString(1, trip.getCarType());
            preparedStatement.setDate(2, trip.getDepartureDate());
            preparedStatement.setTime(3, trip.getDepartureTime());
            preparedStatement.setString(4, trip.getDestination());
            preparedStatement.setString(5, trip.getDriver());
            preparedStatement.setInt(6, trip.getMaximumOnlineTicketNumber());

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
    public List<Trip> viewAllTrip() throws SQLException, ParseException {
        List<Trip> trips = new ArrayList<>();
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TRIP_QUERY_GET_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int tripId = rs.getInt("tripId");
                int bookedTicketNumber = rs.getInt("bookedTicketNumber");
                Time departureTime = rs.getTime("departureTime");
                String destination = rs.getString("destination");
                String driver = rs.getString("driver");
                String carType = rs.getString("carType");
                int maximumOnlineTicketNumber = rs.getInt("maximumOnlineTicketNumber");
                Date departureDate = rs.getDate("departureDate");

                trips.add(new Trip(tripId, bookedTicketNumber, carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber));
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
        return trips;
    }

    @Override
    public List<Trip> searchTrip(String key, int id) throws SQLException, ParseException {
        return null;
    }

    @Override
    public boolean editTrip(Trip trip) throws SQLException, ParseException {
        return false;
    }

    @Override
    public boolean deleteTrip(int id) throws SQLException, ParseException {
        boolean rowDeleted = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TRIP_QUERY_DELETE_BY_ID);
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
    public Trip getTripById(long id) {
        Trip trip = null;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TRIP_QUERY_GET_BY_ID);
            preparedStatement.setLong(1, id);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                trip = new Trip();
                trip.setTripId(results.getInt("tripId"));
                trip.setDestination(results.getString("destination"));
                trip.setDepartureTime(results.getTime("departureTime"));
                trip.setDriver(results.getString("driver"));
                trip.setCarType(results.getString("carType"));
                trip.setBookedTicketNumber(results.getInt("bookedTicketNumber"));
                trip.setDepartureDate(results.getDate("departureDate"));
                trip.setMaximumOnlineTicketNumber(results.getInt("maximumOnlineTicketNumber"));
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
        return trip;
    }


    @Override
    public Trip getTripByName(String name) throws SQLException, ParseException {
        Trip trip = null;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TRIP_QUERY_GET_BY_NAME);
            preparedStatement.setString(1, name);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                trip = new Trip();
                trip.setTripId(results.getInt("tripId"));
                trip.setDestination(results.getString("destination"));
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
        return trip;
    }

    @Override
    public boolean updateTrip(Trip trip) throws SQLException, ClassNotFoundException {
        boolean check;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.TRIP_QUERY_UPDATE);
            preparedStatement.setString(1, trip.getCarType());
            preparedStatement.setDate(2, trip.getDepartureDate());
            preparedStatement.setTime(3, trip.getDepartureTime());
            preparedStatement.setString(4, trip.getDestination());
            preparedStatement.setString(5, trip.getDriver());
            preparedStatement.setInt(6, trip.getMaximumOnlineTicketNumber());
            preparedStatement.setLong(7, trip.getTripId());

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
