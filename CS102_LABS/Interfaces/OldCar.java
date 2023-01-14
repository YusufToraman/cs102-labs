package Interfaces;

public class OldCar implements Car{

    @Override
    public void accelerate() {
        System.out.println("OldCar accelerates");
        
    }

    @Override
    public void decelerate() {
        System.out.println("OldCar decelerates");
        
    }

    @Override
    public void turn(String direction) {
        System.out.println("Old car turns to " + direction);
        
    }

    public void debriyaj(){
        System.out.println("Eski araba debriyaja bastı");
    }
    
}
