package Interfaces;

public class CarShop {
    public static void main(String[] args) {
        Car oldCar1 = new OldCar();
        ((OldCar)oldCar1).debriyaj();
        Car teslaX1 = new TeslaX();
        teslaX1.accelerate();
        ((TeslaX)teslaX1).koltukIsıtması();

        TeslaX teslaX2 = new TeslaX();
        teslaX2.koltukIsıtması();
    }
}
