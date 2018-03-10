import java.util.Date;


public class motorBike extends Abstract {
    private double engineCapacity;

    public motorBike(String vehicleName, String vehicleNum, int wheeler,String date, double engineCapacity){
        super(vehicleName , vehicleNum , wheeler, date);
        this.engineCapacity = engineCapacity;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

}
