package fa.trainning.entities;

import java.sql.Date;
import java.sql.Time;

public class Trip {
    private long tripId;
    private int bookedTicketNumber;
    private String carType;
    private Date departureDate;
    private Time departureTime;
    private String destination;
    private String driver;
    private int maximumOnlineTicketNumber;

    public Trip() {
    }

    public Trip(long tripId, String destination) {
        this.tripId = tripId;
        this.destination = destination;
    }

    public Trip(String carType, Date departureDate, Time departureTime, String destination, String driver, int maximumOnlineTicketNumber) {
        this.carType = carType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.driver = driver;
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }


    public Trip(long tripId, String carType, Date departureDate, Time departureTime, String destination, String driver, int maximumOnlineTicketNumber) {
        this.tripId = tripId;
        this.carType = carType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.driver = driver;
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public Trip(long tripId, int bookedTicketNumber, String carType, Date departureDate, Time departureTime, String destination, String driver, int maximumOnlineTicketNumber) {
        this.tripId = tripId;
        this.bookedTicketNumber = bookedTicketNumber;
        this.carType = carType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.driver = driver;
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public int getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(int bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trip{");
        sb.append("tripId=").append(tripId);
        sb.append(", bookedTicketNumber=").append(bookedTicketNumber);
        sb.append(", carType='").append(carType).append('\'');
        sb.append(", departureDate=").append(departureDate);
        sb.append(", departureTime=").append(departureTime);
        sb.append(", destination='").append(destination).append('\'');
        sb.append(", driver='").append(driver).append('\'');
        sb.append(", maximumOnlineTicketNumber=").append(maximumOnlineTicketNumber);
        sb.append('}');
        return sb.toString();
    }
}
