package fa.trainning.entities;

import java.sql.Date;

public class BookingOffice {
    private long officeId;
    private Date endContractDeadline;
    private String officeName;
    private String officePhone;
    private String officePlace;
    private long officePrice;
    private Date startContractDeadline;
    private long tripId;

    public BookingOffice() {
    }

    public BookingOffice(long officeId, String officeName, long tripId) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.tripId = tripId;
    }

    public BookingOffice(Date endContractDeadline, String officeName, String officePhone, String officePlace, long officePrice, Date startContractDeadline, long tripId) {
        this.endContractDeadline = endContractDeadline;
        this.officeName = officeName;
        this.officePhone = officePhone;
        this.officePlace = officePlace;
        this.officePrice = officePrice;
        this.startContractDeadline = startContractDeadline;
        this.tripId = tripId;
    }

    public BookingOffice(long officeId, Date endContractDeadline, String officeName, String officePhone, String officePlace, long officePrice, Date startContractDeadline, long tripId) {
        this.officeId = officeId;
        this.endContractDeadline = endContractDeadline;
        this.officeName = officeName;
        this.officePhone = officePhone;
        this.officePlace = officePlace;
        this.officePrice = officePrice;
        this.startContractDeadline = startContractDeadline;
        this.tripId = tripId;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public Date getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(Date endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public long getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(long officePrice) {
        this.officePrice = officePrice;
    }

    public Date getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(Date startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookingOffice{");
        sb.append("officeId=").append(officeId);
        sb.append(", endContractDeadline=").append(endContractDeadline);
        sb.append(", officeName='").append(officeName).append('\'');
        sb.append(", officePhone='").append(officePhone).append('\'');
        sb.append(", officePlace='").append(officePlace).append('\'');
        sb.append(", officePrice=").append(officePrice);
        sb.append(", startContractDeadline=").append(startContractDeadline);
        sb.append(", tripId=").append(tripId);
        sb.append('}');
        return sb.toString();
    }
}
