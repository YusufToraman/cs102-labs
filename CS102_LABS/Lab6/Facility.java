package Lab6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Facility {
    private int noOfRoom;
    protected ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Integer> tmp;
    public void importFacility(String filename) throws IOException{
        noOfRoom = 0;
        int kTmp = 0;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.close();
        br = new BufferedReader(new FileReader(filename));
        noOfRoom = Integer.parseInt(br.readLine());
        for(int i = 0; br.ready(); i++){
        StringTokenizer st = new StringTokenizer(br.readLine(), " -");
            if(st.countTokens() == 2 && i < noOfRoom){
                String name = st.nextToken();
                int security = Integer.parseInt(st.nextToken());
                Room r = new Room(name, security);
                rooms.add(r);
            }
            else if(st.countTokens() == 2 && i >= noOfRoom){
                String room = st.nextToken();
                String neighbour = st.nextToken();
                Room r1 = rooms.get(0);
                for(int k = 0; k < rooms.size(); k++){
                    if(rooms.get(k).getName().equals(neighbour)){
                        r1 = rooms.get(k);
                        kTmp = k;
                        break;
                    }
                }
                Room r2 = rooms.get(0);
                for(int m = 0; m < rooms.size(); m++){
                    if(rooms.get(m).getName().equals(room)){
                        r2 = rooms.get(m);
                        rooms.get(m).connectedRooms.add(r1);
                        rooms.get(kTmp).connectedRooms.add(r2);
                        break;
                    }
                }
            }
        }
        tmp = new ArrayList<Integer>();
        for(int i = 0; i < rooms.size(); i++){
            tmp.add(rooms.get(i).getSecurityLevel());
        }
        br.close();
    }
    
    public void securityAttack(String roomName, int attackLevel){
        Room rTmp = new Room("", 0);
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getName().equals(roomName)){
                rTmp = rooms.get(i);
                if(attackLevel > rooms.get(i).getSecurityLevel() && !rooms.get(i).isBreached()){
                    rooms.get(i).setSecurityLevel(rooms.get(i).getSecurityLevel() + 1);
                    rooms.get(i).setBreached(true);
                    System.out.println("Room " + rooms.get(i).getName() + " is breached and its security level increased to: " + rooms.get(i).getSecurityLevel());
                    spreadAttack(rTmp, attackLevel);
                    break;
                }
            }
        }       
    }

    public void spreadAttack(Room rTmp, int attackLevel){
        for(int i = 0; i < rTmp.connectedRooms.size(); i++){
            securityAttack(rTmp.connectedRooms.get(i).getName(), attackLevel);
        }
    }

    public void simulateAttack(int numberOfTries){
        for(int i = 0; i < numberOfTries; i++){
            Room r = selectRandomRoom();
            securityAttack(r.getName(), (i + 1));
        }
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getSecurityLevel() != tmp.get(i)){
                System.out.println(rooms.get(i).getName() +": " + tmp.get(i) + " to " + rooms.get(i).getSecurityLevel());
                rooms.get(i).setSecurityLevel(tmp.get(i));
            }
        }
    }

    public void printAll(){
        for(int i = 0; i < rooms.size(); i++){
            System.out.println("Room Name: " + rooms.get(i).getName() + " Its security level: " + rooms.get(i).getSecurityLevel());
        }
    }

    public Room selectRandomRoom(){
        Room newRoom = new Room(" ", 0);
        int rand = (int) (Math.random() * rooms.size());
        newRoom = rooms.get(rand);
        return newRoom;
    }
}