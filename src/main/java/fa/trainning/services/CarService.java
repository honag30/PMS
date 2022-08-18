package fa.trainning.services;

import fa.trainning.daoi.CarDAOI;
import fa.trainning.daoi.DAOFactory;
import fa.trainning.entities.Car;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CarService implements AutoCloseable{
    private final CarDAOI carDAO = DAOFactory.getNewCarDAO();

    public boolean createCarService(Car car)  throws SQLException, ParseException {
        return carDAO.createCar(car);
    }
    public List<Car> viewAllCarService()  throws SQLException, ParseException {
        return carDAO.viewAllCar();
    }
    public List<Car> searchCarService(String key, int id)  throws SQLException, ParseException {
        return carDAO.searchCar(key, id);
    }

    public boolean editCarService(Car car)  throws SQLException, ParseException {
        return carDAO.editCar(car);
    }

    public boolean updateCarService(Car car) throws SQLException, ClassNotFoundException {
        return carDAO.updateCar(car);
    }

    public boolean deleteCarService(String licensePlate)  throws SQLException, ParseException {
        return carDAO.deleteCar(licensePlate);
    }

    public Car getCarByLicensePlateService(String licensePlate)  throws SQLException, ParseException{
        return carDAO.getCarByLicensePlate(licensePlate);
    }

    @Override
    public void close() throws Exception {

    }
}
