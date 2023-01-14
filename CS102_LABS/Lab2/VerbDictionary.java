package Lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VerbDictionary {
    private ArrayList <Verb> verbList;

    public void processDictionary(String fileName) throws IOException{ 
        BufferedReader inFile = new BufferedReader(new FileReader(fileName));  

        verbList = new ArrayList<>();

        while(inFile.ready()){  //VerbList.size() deneyebilirsin constant'tan kurtulmak için

            StringTokenizer st = new StringTokenizer(inFile.readLine(),"\t");

            if(st.countTokens() == 5){
                String v1 = st.nextToken();
                String v2 = st.nextToken();
                String v3 = st.nextToken();
                String v4 = st.nextToken();
                String v5 = st.nextToken();

                Verb v = new Verb(v1, v2, v3, v4, v5);
                verbList.add(v);
            }
        }
        inFile.close();
    }

    public ArrayList<Verb> getVerbList(){
        return verbList;
    }

    public int findVerbIndex(String word){
        // Iterate 6710 verb
        for(int i = 0; i < verbList.size(); i++){
            if(verbList.get(i).check(word)){
                return i;
            }
        }
        return -1;
    }
}