package Lab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Path {
    private Instruction [] instructions;
    private char [] cardinals;
    private int [] units;

    public Path(String filename) throws IOException{

        int count = 0;
        BufferedReader inFile = new BufferedReader(new FileReader("Lab4/Paths/" + filename));
        while (inFile.readLine() != null) {
            count++;
        } 

        instructions = new Instruction[count];

        cardinals = new char [count];
        units = new int [count];
        inFile.close();

        inFile = new BufferedReader(new FileReader("Lab4/Paths/" + filename));
        while(inFile.ready()){
            for(int i = 0; i < cardinals.length; i++){
                String line = inFile.readLine();
                StringTokenizer st = new StringTokenizer(line, " ");
                if(st.countTokens() == 2){
                    cardinals[i] = st.nextToken().charAt(0);
                    units[i] = Integer.parseInt(st.nextToken());
                }
            }
        }
        inFile.close(); 

        setInstructions();
    }

    public void setInstructions() throws FileNotFoundException{
        for(int i = 0; i < cardinals.length; i++){
            instructions[i] = new Instruction(cardinals[i], units[i]);
        }
    }

    public Instruction[] getInstructions(){
        return instructions;
    }

    public char [] getCardinals(){
        return cardinals;
    }

    public int [] getUnits(){
        return units;
    }
}
