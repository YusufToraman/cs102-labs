package Lab4;

public class Instruction {

    private char cardinal;
    private int unit;

    public Instruction(char cardinal, int unit){
        this.cardinal = cardinal;
        this.unit = unit;
    }

    public boolean move(Map map){
        if(cardinal == 'N'){
            int tmpX = map.getCurrentPosition()[0];
            for(int i = 0; i < unit; i++){
                if(map.getMap()[map.getCurrentPosition()[0] - 1][map.getCurrentPosition()[1]] != 'B'){
                    map.getCurrentPosition()[0] -= 1;
                }
                else{
                    map.getCurrentPosition()[0] = tmpX;
                    return false;
                }
            }
        }
        else if(cardinal == 'S'){
            int tmpX = map.getCurrentPosition()[0];
            for(int i = 0; i < unit; i++){
                if(map.getMap()[map.getCurrentPosition()[0] + 1][map.getCurrentPosition()[1]] != 'B'){
                    map.getCurrentPosition()[0] += 1;
                }
                else{
                    map.getCurrentPosition()[0] = tmpX;
                    return false;
                }
            }
        }
        else if(cardinal == 'E'){
            int tmpY = map.getCurrentPosition()[1];
            for(int i = 0; i < unit; i++){
                if(map.getMap()[map.getCurrentPosition()[0]][map.getCurrentPosition()[1] + 1] != 'B'){
                    map.getCurrentPosition()[1] += 1;
                }
                else{
                    map.getCurrentPosition()[1] = tmpY;
                    return false;
                }
            }
        }
        else if(cardinal == 'W'){
            int tmpY = map.getCurrentPosition()[1];
            for(int i = 0; i < unit; i++){
                if(map.getMap()[map.getCurrentPosition()[0]][map.getCurrentPosition()[1] - 1] != 'B'){
                    map.getCurrentPosition()[1] -= 1;
                }
                else{
                    map.getCurrentPosition()[1] = tmpY;
                    return false;
                }
            }
        }
        return true;
    }

    public String toString(){
        String output = "";
        output = "Direction: " + cardinal + "    Unit: " + unit;
        return output;
    }
    
}
