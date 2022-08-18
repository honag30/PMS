package fa.trainning.entities;

public class ParkingLot {

    private long parkId;
    private long parkArea;
    private String parkName;
    private String parkPlace;
    private long parkPrice;
    private String parkStatus;

    public ParkingLot() {
        super();
    }

    public ParkingLot(long parkId, long parkArea, String parkName, String parkPlace, long parkPrice, String parkStatus) {
        super();
        this.parkId = parkId;
        this.parkArea = parkArea;
        this.parkName = parkName;
        this.parkPlace = parkPlace;
        this.parkPrice = parkPrice;
        this.parkStatus = parkStatus;
    }

    public ParkingLot(long parkId, long parkArea, String parkName, String parkPlace, long parkPrice) {
        super();
        this.parkId = parkId;
        this.parkArea = parkArea;
        this.parkName = parkName;
        this.parkPlace = parkPlace;
        this.parkPrice = parkPrice;

    }

    public ParkingLot(long parkArea, String parkName, String parkPlace, long parkPrice) {
        super();
        this.parkArea = parkArea;
        this.parkName = parkName;
        this.parkPlace = parkPlace;
        this.parkPrice = parkPrice;

    }

    public long getParkId() {
        return parkId;
    }

    public void setParkId(long parkId) {
        this.parkId = parkId;
    }

    public long getParkArea() {
        return parkArea;
    }

    public void setParkArea(long parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public long getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(long parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }

}
