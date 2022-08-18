package fa.trainning.entities;

public class Car {
    private String licensePlate;
    private String carColor;
    private String carType;
    private String company;
    private long parkId;

    public Car() {
    }

    public Car(String carColor, String carType, String company, long parkId) {
        this.carColor = carColor;
        this.carType = carType;
        this.company = company;
        this.parkId = parkId;
    }

    public Car(String licensePlate, String carColor, String carType, String company, long parkId) {
        this.licensePlate = licensePlate;
        this.carColor = carColor;
        this.carType = carType;
        this.company = company;
        this.parkId = parkId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public long getParkId() {
        return parkId;
    }

    public void setParkId(long parkId) {
        this.parkId = parkId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("licensePlate='").append(licensePlate).append('\'');
        sb.append(", carColor='").append(carColor).append('\'');
        sb.append(", carType='").append(carType).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", parkId=").append(parkId);
        sb.append('}');
        return sb.toString();
    }
}
