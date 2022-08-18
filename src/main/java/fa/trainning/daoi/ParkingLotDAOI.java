package fa.trainning.daoi;

import fa.trainning.entities.ParkingLot;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ParkingLotDAOI {
    boolean createParkingLot(ParkingLot parkingLot) throws SQLException, ParseException;
    List<ParkingLot> viewAllParkingLot() throws SQLException, ParseException;
    List<ParkingLot> searchParkingLot(String key, int id) throws SQLException, ParseException;
    boolean editParkingLot(ParkingLot parkingLot) throws SQLException, ParseException;
    boolean deleteParkingLot(int id) throws SQLException, ParseException;
    ParkingLot getParkingLotById(int id) throws SQLException, ParseException;
    boolean updateParkingLot(ParkingLot parkingLot) throws SQLException, ClassNotFoundException;
    ParkingLot getParkingLotByName(String parkName) throws SQLException, ClassNotFoundException;
}
