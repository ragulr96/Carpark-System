import java.util.Date;
import java.sql.Time;

public class Car extends Abstract {
    private String colour;
    private int doors;

    public Car(String vehicleName, String vehicleNum, int wheeler, String colour, String date, int doors){
        super(vehicleName , vehicleNum , wheeler , date );
        this.colour = colour;
        this.doors = doors;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
