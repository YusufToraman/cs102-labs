package Interfaces;

public class TeslaX implements Car{

    @Override
    public void accelerate() {
        // TODO Auto-generated method stub
        System.out.println("TeslaX accelerates");
    }

    @Override
    public void decelerate() {
        
        System.out.println("TeslaX decelerates");
    }

    @Override
    public void turn(String direction) {
        System.out.println("TeslaX turn to " + direction);        
    }

    public void koltukIsıtması(){
        System.out.println("Tesla koltuk ısıtması açtı");
    }

}
