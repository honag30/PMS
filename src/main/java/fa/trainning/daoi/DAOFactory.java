package fa.trainning.daoi;

import fa.trainning.dao.*;

public class DAOFactory {
    public static EmployeeDAOI getNewEmployeeDAO() {
        return new EmployeeDAO();
    }
    public static BookingOfficeDAOI getNewBookingOfficeDAO() {
        return new BookingOfficeDAO();
    }
    public static CarDAOI getNewCarDAO() {
        return new CarDAO();
    }
    public static ParkingLotDAOI getNewParkingLotDAO() {
        return new ParkingLotDAO();
    }
    public static TicketDAOI getNewTicketDAO() {
        return new TicketDAO();
    }
    public static TripDAOI getNewTripDAO() {
        return new TripDAO();
    }
}
