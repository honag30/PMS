package fa.trainning.services;

import fa.trainning.daoi.TripDAOI;
import fa.trainning.daoi.DAOFactory;
import fa.trainning.entities.Trip;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class TripService implements  AutoCloseable{

    private final TripDAOI tripDAO = DAOFactory.getNewTripDAO();

    public boolean createTripService(Trip trip)  throws SQLException, ParseException {
        return tripDAO.createTrip(trip);
    }
    public List<Trip> viewAllTripService()  throws SQLException, ParseException {
        return tripDAO.viewAllTrip();
    }
    public List<Trip> searchTripService(String key, int id)  throws SQLException, ParseException {
        return tripDAO.searchTrip(key, id);
    }

    public boolean editTripService(Trip trip)  throws SQLException, ParseException {
        return tripDAO.editTrip(trip);
    }

    public boolean updateTripService(Trip trip) throws SQLException, ParseException, ClassNotFoundException {
        return tripDAO.updateTrip(trip);
    }

    public boolean deleteTripService(int id)  throws SQLException, ParseException {
        return tripDAO.deleteTrip(id);
    }

    public Trip getTripByIdService(long id)  throws SQLException, ParseException{
        return tripDAO.getTripById(id);
    }

    public Trip getTripByNameService(String name)  throws SQLException, ParseException{
        return tripDAO.getTripByName(name);
    }

    @Override
    public void close() throws Exception {

    }
}
