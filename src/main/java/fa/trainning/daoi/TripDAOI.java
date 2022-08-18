package fa.trainning.daoi;

import fa.trainning.entities.Trip;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface TripDAOI {

    boolean createTrip(Trip trip) throws SQLException, ParseException;
    List<Trip> viewAllTrip() throws SQLException, ParseException;
    List<Trip> searchTrip(String key, int id) throws SQLException, ParseException;
    boolean editTrip(Trip trip) throws SQLException, ParseException;
    boolean deleteTrip(int id) throws SQLException, ParseException;
    Trip getTripById(long id) throws SQLException, ParseException;
    Trip getTripByName(String name) throws SQLException, ParseException;
    boolean updateTrip(Trip trip) throws SQLException, ClassNotFoundException;
}
