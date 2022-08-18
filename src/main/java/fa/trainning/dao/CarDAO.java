package fa.trainning.dao;

import fa.trainning.connect.DBUtils;
import fa.trainning.daoi.CarDAOI;
import fa.trainning.entities.Car;
import fa.trainning.entities.Car;
import fa.trainning.utils.ErrorHandling;
import fa.trainning.utils.SQLCommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements CarDAOI {
    DBUtils dbhelper = DBUtils.getDBHelper();
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet results = null;

    @Override
    public boolean createCar(Car car) throws SQLException, ParseException {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.CAR_QUERY_CREATE);

            preparedStatement.setString(1, car.getLicensePlate());
            preparedStatement.setString(2, car.getCarColor());
            preparedStatement.setString(3, car.getCarType());
            preparedStatement.setString(4, car.getCompany());
            preparedStatement.setLong(5, car.getParkId());
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
    public List<Car> viewAllCar() throws SQLException, ParseException {
        List<Car> cars = new ArrayList<>();
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.CAR_QUERY_GET_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String licensePlate = rs.getString("licensePlate");
                String carColor = rs.getString("carColor");
                String carType = rs.getString("carType");
                String company = rs.getString("company");
                long parkId = rs.getLong("parkId");
                cars.add(new Car(licensePlate, carColor, carType, company, parkId));
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
        return cars;
    }

    @Override
    public List<Car> searchCar(String key, int id) throws SQLException, ParseException {
        return null;
    }

    @Override
    public boolean editCar(Car car) throws SQLException, ParseException {
        return false;
    }

    @Override
    public boolean deleteCar(String licensePlate) {
        boolean rowDeleted = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM [dbo].[Car] WHERE [Car].[licensePlate]='"+  licensePlate +"';"
            );
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
    public Car getCarByLicensePlate(String licensePlate) throws SQLException, ParseException {
        Car car = null;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.CAR_QUERY_GET_BY_LICENSE_PLATE);
            preparedStatement.setString(1, licensePlate);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                car = new Car();
                car.setLicensePlate(licensePlate);
                car.setCarColor(results.getString("carColor"));
                car.setCarType(results.getString("carType"));
                car.setCompany(results.getString("company"));
                car.setParkId(results.getLong("parkId"));
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
        return car;
    }

    @Override
    public boolean updateCar(Car car) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.CAR_QUERY_UPDATE);

            preparedStatement.setString(1, car.getCarColor());
            preparedStatement.setString(2, car.getCarType());
            preparedStatement.setString(3, car.getCompany());
            preparedStatement.setLong(4, car.getParkId());
            preparedStatement.setString(5, car.getLicensePlate());
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
