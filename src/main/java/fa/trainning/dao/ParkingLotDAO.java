package fa.trainning.dao;

import fa.trainning.connect.DBUtils;
import fa.trainning.daoi.ParkingLotDAOI;
import fa.trainning.entities.ParkingLot;
import fa.trainning.utils.ErrorHandling;
import fa.trainning.utils.SQLCommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotDAO implements ParkingLotDAOI {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet results = null;

    DBUtils dbhelper = DBUtils.getDBHelper();


    @Override
    public boolean createParkingLot(ParkingLot parkingLot) throws SQLException, ParseException {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.PARKING_LOT_QUERY_CREATE);

            preparedStatement.setString(1, parkingLot.getParkName());
            preparedStatement.setString(2, parkingLot.getParkPlace());
            preparedStatement.setLong(3, parkingLot.getParkArea());
            preparedStatement.setLong(4, parkingLot.getParkPrice());
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
    public List<ParkingLot> viewAllParkingLot() throws SQLException, ParseException {
        List<ParkingLot> parkingLots = new ArrayList<>();
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.PARKING_LOT_OFFICE_QUERY_GET_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int parkId = rs.getInt("parkId");
                long parkArea = rs.getLong("parkArea");
                String parkName = rs.getString("parkName");
                String parkPlace = rs.getString("parkPlace");
                long parkPrice = rs.getLong("parkPrice");
                String parkStatus = rs.getString("parkStatus");
                parkingLots.add(new ParkingLot(parkId, parkArea, parkName, parkPlace, parkPrice, parkStatus));
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
        return parkingLots;
    }

    @Override
    public List<ParkingLot> searchParkingLot(String key, int id) throws SQLException, ParseException {
        return null;
    }

    @Override
    public boolean editParkingLot(ParkingLot parkingLot) throws SQLException, ParseException {
        return false;
    }

    @Override
    public boolean deleteParkingLot(int id) throws SQLException, ParseException {
        boolean rowDeleted = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.PARKING_LOT_QUERY_DELETE_BY_ID);
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
    public ParkingLot getParkingLotById(int id) throws SQLException, ParseException {
        ParkingLot parkingLot = null;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.PARKING_LOT_QUERY_GET_BY_ID);
            preparedStatement.setInt(1, id);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                parkingLot = new ParkingLot();
                parkingLot.setParkId(id);
                parkingLot.setParkArea(results.getLong("parkArea"));
                parkingLot.setParkName(results.getString("parkName"));
                parkingLot.setParkPlace(results.getString("parkPlace"));
                parkingLot.setParkPrice(results.getLong("parkPrice"));
                parkingLot.setParkStatus(results.getString("parkStatus"));

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
        return parkingLot;
    }

    @Override
    public boolean updateParkingLot(ParkingLot parkingLot) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.PARKING_LOT_QUERY_UPDATE);
            preparedStatement.setLong(1, parkingLot.getParkArea());
            preparedStatement.setString(2, parkingLot.getParkName());
            preparedStatement.setString(3, parkingLot.getParkPlace());
            preparedStatement.setLong(4, parkingLot.getParkPrice());
            preparedStatement.setLong(5, parkingLot.getParkId());
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
    public ParkingLot getParkingLotByName(String parkName) throws SQLException, ClassNotFoundException {
        ParkingLot parkingLot = null;
        try {
            connection = dbhelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.PARKING_LOT_QUERY_GET_BY_NAME);
            preparedStatement.setString(1, parkName);
            results = preparedStatement.executeQuery();
            if (results.next()) {
                parkingLot = new ParkingLot();
                parkingLot.setParkId(results.getInt("parkId"));
                parkingLot.setParkName(results.getString("parkName"));
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
        return parkingLot;
    }
}
