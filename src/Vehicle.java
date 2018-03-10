public class Vehicle {
    private String vehicleName;
    private String vehicleNum;
    private int wheeler;
    private DateTime date;

    public Vehicle(String vehicleName, String vehicleNum, int wheeler, String date) {
        this.vehicleName = vehicleName;
        this.vehicleNum = vehicleNum;
        this.wheeler = wheeler;
        String []day = date.split("\\.");

        this.date = new DateTime(Integer.parseInt(day[0]), Integer.parseInt(day[1]), Integer.parseInt(day[2]), Integer.parseInt(day[3]), Integer.parseInt(day[4]), Integer.parseInt(day[5]));

    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public int getWheeler() {
        return wheeler;
    }


    public void setWheeler(int wheeler) {
        this.wheeler = wheeler;
    }

    public DateTime getDate() {
        return date;
    }
}
