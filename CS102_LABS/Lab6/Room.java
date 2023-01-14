package Lab6;

import java.util.ArrayList;

public class Room {
    protected ArrayList<Room> connectedRooms;
    private String name;
    private int securityLevel;
    private boolean breached;
    //Name and level
    public Room(String name, int securityLevel){
        connectedRooms = new ArrayList<>();
        breached = false;
        this.name = name;
        this.securityLevel = securityLevel;
    }

    public String getName(){
        return name;
    }

    public int getSecurityLevel(){
        return securityLevel;
    }

    public void setSecurityLevel(int secLev){
        securityLevel = secLev;
    }

    public boolean isBreached(){
        return breached;
    }

    public void setBreached(boolean breach){
        breached = breach;
    }
}
