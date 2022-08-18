package fa.trainning.utils;

public class SQLCommand {
    // For Booking Employee
    public static final String EMPLOYEE_QUERY_LOGIN =
            "SELECT [Employee].[employeeId], [Employee].[employeeEmail], [Employee].[account], [Employee].[password],[Employee].[role]  FROM [dbo].[Employee] \n" +
                "WHERE [Employee].[EmployeeEmail] = ? \n" +
                "AND [Employee].[Password] = ?";
    public static final String EMPLOYEE_QUERY_GET_ALL =
            "SELECT [Employee].[employeeId],[Employee].[employeeName], [Employee].[employeeBirthdate], [Employee].[employeeAddress], [Employee].[employeePhone],[Employee].[department] \n" +
                    "FROM [dbo].[Employee];";

    public static final String EMPLOYEE_QUERY_DELETE_BY_ID =
            "DELETE FROM [dbo].[Employee] WHERE [Employee].[employeeId]=?;";
    public static final String EMPLOYEE_QUERY_GET_BY_ID =
            "SELECT * FROM [dbo].[Employee] WHERE [Employee].[employeeId]=?";
    public static final String EMPLOYEE_QUERY_UPDATE =
            "UPDATE [dbo].[Employee]\n" +
                    "SET [Employee].[account]=?, [Employee].[department]=?, [Employee].[employeeAddress]=?, [Employee].[employeeBirthDate]=?, [Employee].[employeeEmail]=?, [Employee].[employeeName]=?, [Employee].[employeePhone]=?, [Employee].[password]=?, [Employee].[sex]=? \n" +
                    "WHERE [Employee].[employeeId] =?";
    public static final String EMPLOYEE_QUERY_CREATE =
            "INSERT INTO " +
                    "[dbo].[Employee]([Employee].[account], [Employee].[department], [Employee].[employeeAddress], [Employee].[employeeBirthDate], [Employee].[employeeEmail], [Employee].[employeeName], [Employee].[employeePhone], [Employee].[password], [Employee].[sex], [Employee].[role])\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 'staff');";

    public static final String EMPLOYEE_QUERY_GET_BY_EMAIL =
            "SELECT [Employee].[account], [Employee].[department], [Employee].[employeeAddress], [Employee].[employeeBirthDate], [Employee].[employeeEmail], [Employee].[employeeName], [Employee].[employeePhone], [Employee].[sex] \n" +
                    " FROM [dbo].[Employee] \n" +
                    "WHERE [Employee].[employeeEmail]=?";


    // For Booking Office
    public static final String BOOKING_OFFICE_QUERY_GET_ALL =
            "SELECT [BookingOffice].[officeId],[BookingOffice].[officeName],[BookingOffice].[tripId]\n" +
                    "FROM [dbo].[BookingOffice]";
    public static final String BOOK_OFFICE_QUERY_CREATE =
            "INSERT INTO " +
                    "[dbo].[BookingOffice]([BookingOffice].[officeName], [BookingOffice].[tripId], [BookingOffice].[officePhone], [BookingOffice].[officePlace], [BookingOffice].[officePrice], [BookingOffice].[startContractDeadline], [BookingOffice].[endContractDeadline])\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";
    public static final String BOOKING_OFFICE_QUERY_GET_BY_ID =
            "SELECT [BookingOffice].[officeName], [BookingOffice].[tripId], [BookingOffice].[officePhone], [BookingOffice].[officePlace], [BookingOffice].[officePrice], [BookingOffice].[startContractDeadline], [BookingOffice].[endContractDeadline]\n" +
                    " FROM [dbo].[BookingOffice] \n" +
                    "WHERE [BookingOffice].[officeId]=?";
    public static final String BOOKING_OFFICE_QUERY_UPDATE =
            "UPDATE [dbo].[BookingOffice]\n" +
                    "SET [BookingOffice].[officeName]=?, [BookingOffice].[tripId]=?, [BookingOffice].[officePhone]=?, [BookingOffice].[officePlace]=?, [BookingOffice].[officePrice]=?, [BookingOffice].[startContractDeadline]=?, [BookingOffice].[endContractDeadline]=?\n" +
                    "WHERE [BookingOffice].[officeId] =?";
    public static final String BOOKING_OFFICE_QUERY_DELETE_BY_ID =
            "DELETE FROM [dbo].[BookingOffice] WHERE [BookingOffice].[officeId]=?;";

    // For Parking Lot
    public static final String PARKING_LOT_OFFICE_QUERY_GET_ALL =
            "SELECT [ParkingLot].[parkId], [ParkingLot].[parkArea], [ParkingLot].[parkName], [ParkingLot].[parkPlace], [ParkingLot].[parkPrice], [ParkingLot].[parkStatus]\n" +
                    "FROM [dbo].[ParkingLot]";
    public static final String PARKING_LOT_QUERY_CREATE =
            "INSERT INTO " +
                    "[dbo].[ParkingLot]([ParkingLot].[parkName], [ParkingLot].[parkPlace], [ParkingLot].[parkArea], [ParkingLot].[parkPrice], [ParkingLot].[parkStatus])\n" +
                    "VALUES (?, ?, ?, ?, 'Available');";
    public static final String PARKING_LOT_QUERY_DELETE_BY_ID =
            "DELETE FROM [dbo].[ParkingLot] WHERE [ParkingLot].[parkId]=?;";
    public static final String PARKING_LOT_QUERY_GET_BY_ID =
            "SELECT [ParkingLot].[parkId], [ParkingLot].[parkArea], [ParkingLot].[parkName], [ParkingLot].[parkPlace], [ParkingLot].[parkPrice], [ParkingLot].[parkStatus]\n" +
                    " FROM [dbo].[ParkingLot] \n" +
                    "WHERE [ParkingLot].[parkId]=?";
    public static final String PARKING_LOT_QUERY_UPDATE =
            "UPDATE [dbo].[ParkingLot]\n" +
                    "SET [ParkingLot].[parkArea]=?, [ParkingLot].[parkName]=?, [ParkingLot].[parkPlace]=?, [ParkingLot].[parkPrice]=? \n" +
                    "WHERE [ParkingLot].[parkId] =?";
    public static final String PARKING_LOT_QUERY_GET_BY_NAME =
            "SELECT [ParkingLot].[parkId], [ParkingLot].[parkArea], [ParkingLot].[parkName], [ParkingLot].[parkPlace], [ParkingLot].[parkPrice], [ParkingLot].[parkStatus] \n" +
                    "FROM [dbo].[ParkingLot] \n" +
                    "WHERE [ParkingLot].[parkName]=?";

    // For Booking Trip
    public static final String TRIP_QUERY_GET_BY_ID =
            "SELECT [Trip].[tripId], [Trip].[destination],[Trip].[departureTime],[Trip].[driver],[Trip].[carType],[Trip].[bookedTicketNumber],[Trip].[departureDate],[Trip].[maximumOnlineTicketNumber] \n" +
                    "FROM [dbo].[Trip] \n" +
                    "WHERE [Trip].[tripId]=?";
    public static final String TRIP_QUERY_GET_ALL =
            "SELECT [Trip].[tripId], [Trip].[destination],[Trip].[departureTime],[Trip].[driver],[Trip].[carType],[Trip].[bookedTicketNumber],[Trip].[maximumOnlineTicketNumber], [Trip].[departureDate] \n" +
                    "FROM [dbo].[Trip]; ";
    public static final String TRIP_QUERY_GET_BY_NAME =
            "SELECT [Trip].[tripId], [Trip].[destination],[Trip].[departureTime],[Trip].[driver],[Trip].[carType],[Trip].[bookedTicketNumber] \n" +
                    "FROM [dbo].[Trip] \n" +
                    "WHERE [Trip].[destination]=?";
    public static final String TRIP_QUERY_DELETE_BY_ID =
            "DELETE FROM [dbo].[Trip] WHERE [Trip].[tripId]=?;";
    public static final String TRIP_QUERY_UPDATE =
            "UPDATE [dbo].[Trip]\n" +
                    "SET [Trip].[carType]=?, [Trip].[departureDate]=?, [Trip].[departureTime]=?, [Trip].[destination]=?, [Trip].[driver]=?, [Trip].[maximumOnlineTicketNumber]=? \n" +
                    "WHERE [Trip].[tripId] =?";
    public static final String TRIP_QUERY_CREATE =
            "INSERT INTO " +
                    "[dbo].[Trip]([Trip].[carType], [Trip].[departureDate], [Trip].[departureTime], [Trip].[destination], [Trip].[driver], [Trip].[maximumOnlineTicketNumber], [Trip].[bookedTicketNumber]) \n" +
                    "VALUES (?, ?, ?, ?, ?, ?, 0);";
    public static final String TRIP_QUERY_GET_BOOKED_TICKET =
            "SELECT count(Trip.tripId)  AS bookedTicketNumber \n" +
                    "FROM Trip\n" +
                    "INNER JOIN Ticket  on Trip.tripId = Ticket.tripId\n" +
                    "WHERE Trip.tripId = ?;";

    // For Car
    public static final String CAR_QUERY_CREATE =
            "INSERT INTO " +
                    "[dbo].[Car]([Car].[licensePlate], [Car].[carColor], [Car].[carType], [Car].[company], [Car].[parkId]) \n" +
                    "VALUES (?, ?, ?, ?, ?);";
    public static final String CAR_QUERY_GET_ALL =
            "SELECT [Car].[licensePlate],[Car].[carColor],[Car].[carType],[Car].[company],[Car].[parkId] \n" +
                    "FROM [dbo].[Car];";

    public static final String CAR_QUERY_GET_BY_LICENSE_PLATE =
            "SELECT [Car].[licensePlate], [Car].[carColor], [Car].[carType], [Car].[company], [Car].[parkId] \n" +
                    " FROM [dbo].[Car] \n" +
                    "WHERE [Car].[licensePlate]=?";

    public static final String CAR_QUERY_UPDATE =
            "UPDATE [dbo].[Car]\n" +
                    "SET [Car].[carColor]=?, [Car].[carType]=?, [Car].[company]=?, [Car].[parkId]=? \n" +
                    "WHERE [Car].[licensePlate] =?";

    // For Car
    public static final String TICKET_QUERY_CREATE =
            "INSERT INTO " +
                    "[dbo].[Ticket]([Ticket].[bookTime], [Ticket].[customerName], [Ticket].[licensePlate], [Ticket].[tripId]) \n" +
                    "VALUES (?, ?, ?, ?);";
    public static final String TICKET_QUERY_DELETE_BY_ID =
            "DELETE FROM [dbo].[Ticket] WHERE [Ticket].[ticketId]=?;";
    public static final String TICKET_QUERY_GET_BY_ID =
            "SELECT [Ticket].[tripId], [Ticket].[bookTime],[Ticket].[customerName],[Ticket].[licensePlate],[Ticket].[tripId] \n" +
                    "FROM [dbo].[Ticket] \n" +
                    "WHERE [Ticket].[TicketId]=?";
    public static final String TICKET_QUERY_UPDATE =
            "UPDATE [dbo].[Ticket]\n" +
                    "SET [Ticket].[bookTime] = ?, [Ticket].[customerName]=?, [Ticket].[licensePlate]=?, [Ticket].[tripId]=? \n" +
                    "WHERE [Ticket].[TicketId] =?";
    public static final String TICKET_QUERY_GET_ALL =
            "SELECT [Ticket].[TicketId],[Ticket].[bookTime],[Ticket].[customerName],[Ticket].[licensePlate],[Ticket].[tripId] \n" +
                    "FROM [dbo].[Ticket];";

}