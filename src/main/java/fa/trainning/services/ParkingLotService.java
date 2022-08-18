package fa.trainning.services;

import fa.trainning.daoi.ParkingLotDAOI;
import fa.trainning.daoi.DAOFactory;
import fa.trainning.entities.ParkingLot;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ParkingLotService implements AutoCloseable{
    private final ParkingLotDAOI parkingLotDAO = DAOFactory.getNewParkingLotDAO();

    public boolean createParkingLotService(ParkingLot parkingLot)  throws SQLException, ParseException {
        return parkingLotDAO.createParkingLot(parkingLot);
    }
    public List<ParkingLot> viewAllParkingLotService()  throws SQLException, ParseException {
        return parkingLotDAO.viewAllParkingLot();
    }
    public List<ParkingLot> searchParkingLotService(String key, int id)  throws SQLException, ParseException {
        return parkingLotDAO.searchParkingLot(key, id);
    }

    public boolean editParkingLotService(ParkingLot parkingLot)  throws SQLException, ParseException {
        return parkingLotDAO.editParkingLot(parkingLot);
    }

    public boolean updateParkingLotService(ParkingLot parkingLot) throws SQLException, ClassNotFoundException {
        return parkingLotDAO.updateParkingLot(parkingLot);
    }


    public boolean deleteParkingLotService(int id)  throws SQLException, ParseException {
        return parkingLotDAO.deleteParkingLot(id);
    }

    public ParkingLot getParkingLotByIdService(int id)  throws SQLException, ParseException{
        return parkingLotDAO.getParkingLotById(id);
    }

    public ParkingLot getParkingLotByNameService(String parkName) throws SQLException, ClassNotFoundException {
        return parkingLotDAO.getParkingLotByName(parkName);
    }

    @Override
    public void close() throws Exception {

    }

}
