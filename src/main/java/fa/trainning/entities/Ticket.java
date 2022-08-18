package fa.trainning.entities;

import java.sql.Time;

public class Ticket {
    private long ticketId;
    private Time bookingTime;
    private String customerName;
    private String licensePlate;
    private long tripId;

    public Ticket() {
    }

    public Ticket(Time bookingTime, String customerName, String licensePlate, long tripId) {
        this.bookingTime = bookingTime;
        this.customerName = customerName;
        this.licensePlate = licensePlate;
        this.tripId = tripId;
    }

    public Ticket(long ticketId, Time bookingTime, String customerName, String licensePlate, long tripId) {
        this.ticketId = ticketId;
        this.bookingTime = bookingTime;
        this.customerName = customerName;
        this.licensePlate = licensePlate;
        this.tripId = tripId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ticket{");
        sb.append("ticketId=").append(ticketId);
        sb.append(", bookingTime=").append(bookingTime);
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", licensePlate='").append(licensePlate).append('\'');
        sb.append(", tripId=").append(tripId);
        sb.append('}');
        return sb.toString();
    }
}
