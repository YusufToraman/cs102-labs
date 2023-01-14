package Lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Map {
    private char [][] map;
    private int [] currentPosition;
    private String [] pathFileNames;

    public Map(String fileName) throws IOException{

        this.readMap(fileName);

        currentPosition = new int [2];
        //Set current Position as S point
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == 'S'){
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                }
            }
        }
    }

    public void readMap(String filename) throws IOException{
        BufferedReader inFile = new BufferedReader(new FileReader(filename));
        //countX counts the length of X coordinate of the map and countY is for Y coordinate
        int countX = 0;
        while(inFile.ready()){
            inFile.readLine();
            countX++;
        }
        inFile.close();;
        inFile = new BufferedReader(new FileReader(filename));
        boolean hasCreated = false;
        while(inFile.ready()){
            for(int i = 0; i < countX; i++){
                String line = inFile.readLine();
                if(!hasCreated){
                    map = new char[countX][line.length()];
                    hasCreated = true;
                }
                for(int j = 0; j < line.length(); j++){
                    map[i][j] = line.charAt(j);
                }
            }
        }
        inFile.close();
    }

    public int [] getCurrentPosition(){
        return currentPosition;
    }

    public char[][] getMap(){
        return map;
    }

    public void createPath(String filename) throws IOException{

    }

    public boolean isPathToTreasure(Path p){
        int count = 0;
        for(int i = 0; i < p.getInstructions().length; i++){
            count++;
            if(p.getInstructions()[i].move(this)){
                if(count == p.getInstructions().length){
                    if(this.map[this.getCurrentPosition()[0]][this.getCurrentPosition()[1]] == 'T'){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isMovePossible(Instruction i){
        int tmpX = this.getCurrentPosition()[0];
        int tmpY = this.getCurrentPosition()[1];
        if(i.move(this)){
            this.currentPosition[0] = tmpX;
            this.currentPosition[1] = tmpY;
            return true;
        }
        else{
            return false;
        }
    }

    public void readFromFolder(String folderName) throws IOException{
        File path = new File(folderName);
        pathFileNames = path.list();
    }

    public void processPaths() throws IOException{
        for(int i = 0; i < pathFileNames.length; i++){
            int tmpX = this.getCurrentPosition()[0];
            int tmpY = this.getCurrentPosition()[1];
            if(isPathToTreasure(new Path(pathFileNames[i]))){
                System.out.println(pathFileNames[i] + " has reached the treasure");
            }
            this.getCurrentPosition()[0] = tmpX;
            this.getCurrentPosition()[1] = tmpY;
        }
    }

    public boolean checkPathCombination(Path a, Path b){
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < a.getInstructions().length; i++){
            countA++;
            a.getInstructions()[i].move(this);
            if(countA == a.getInstructions().length){
                for(int j = 0; j < b.getInstructions().length; j++){
                    countB++;
                    b.getInstructions()[j].move(this);
                    if(countB == b.getInstructions().length){
                        if(this.map[this.getCurrentPosition()[0]][this.getCurrentPosition()[1]] == 'T'){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void processPathCombinations() throws IOException{
        for(int i = 0; i < pathFileNames.length; i++){
            int tmpX = this.getCurrentPosition()[0];
            int tmpY = this.getCurrentPosition()[1];
            for(int j = 0; j < pathFileNames.length; j++){
                if(checkPathCombination(new Path(pathFileNames[i]), new Path(pathFileNames[j]))){
                    System.out.println("Combination of Path " + pathFileNames[i] + " and " + pathFileNames[j] + " has reached the treasure.");
                }
                this.getCurrentPosition()[0] = tmpX;
                this.getCurrentPosition()[1] = tmpY;
            }
        }
    }
}
