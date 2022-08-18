package fa.trainning.daoi;

import fa.trainning.entities.Car;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface CarDAOI {
    boolean createCar(Car car) throws SQLException, ParseException;
    List<Car> viewAllCar() throws SQLException, ParseException;
    List<Car> searchCar(String key, int id) throws SQLException, ParseException;
    boolean editCar(Car car) throws SQLException, ParseException;
    boolean deleteCar(String licensePlate) throws SQLException, ParseException;
    Car getCarByLicensePlate(String licensePlate) throws SQLException, ParseException;
    boolean updateCar(Car car) throws SQLException, ClassNotFoundException;
}
