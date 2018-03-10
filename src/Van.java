import java.util.Date;

public class Van extends Abstract {
    private int cargoVolume;

    public Van(String vehicleName, String vehicleNum,  int wheeler, int cargoVolume, String date){
        super(vehicleName , vehicleNum , wheeler , date);
        this.cargoVolume = cargoVolume;
    }

    public int getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }
}
