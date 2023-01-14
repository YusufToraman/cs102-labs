package Interfaces;

public interface Car {
    public static final int numOfWheels = 4;

    public void accelerate();
    public abstract void decelerate();
    void turn(String direction);
}
