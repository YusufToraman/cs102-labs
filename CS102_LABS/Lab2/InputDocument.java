package Lab2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputDocument {
    private int[] noOfOccurence;
    private double totalVerbCount;
    private VerbDictionary verbDictionary;

    public InputDocument(String fileName) throws IOException{


        noOfOccurence = new int [6708];
        totalVerbCount = 0;
        
        verbDictionary = new VerbDictionary();
        verbDictionary.processDictionary("Lab2/verbs-dictionaries.txt");

        Scanner inFile = new Scanner(new File(fileName)); 
        while(inFile.hasNextLine()){
            StringTokenizer st = new StringTokenizer(inFile.nextLine(), ",.?:()-”!;/ <>=[]*'");
            //",//.//?//://(//)//-//”//!//;/// //<//>//=//[//]*//'//"
            while (st.hasMoreElements()) {
                String word = st.nextToken();
                // Kelime verb'mü check et 5 formdan biri mi öyleyse içeri gir

                for(int j = 0; j < verbDictionary.getVerbList().size(); j++){
                    if(verbDictionary.getVerbList().get(j).check(word)){
                        totalVerbCount++;
                        // Verb olan bu kelimenin indexi için findVerbIndex'te return eden değeri arttır array'deki
                        noOfOccurence[verbDictionary.findVerbIndex(word)]++;
                        break;
                    }
                }
            }
        }

    }

    public void printTop5(){
        // Iterate all array for finding max 5 number
        int copyList[] = noOfOccurence;
        int maxList[] = new int[5];
        // Holds the indexes of the word's
        int maxIndexList[] = new int[5];

        for (int i = 0; i < 5; i++) {
            int max = copyList[0];
            int tmp = 0;

            for (int j = 0; j < copyList.length; j++) {
                if (max < copyList[j]) {
                    max = copyList[j];
                    tmp = j;
                    maxIndexList[i] = tmp;
                }
            }
            maxList[i] = max;
            // Max'ı bulduktan sonra bu for içindeki, max'ı küçült yeni max diğeri olcak
            copyList[tmp] = -1;
        } 

        for(int i = 0; i < 5; i++){
            Verb verb = verbDictionary.getVerbList().get(maxIndexList[i]);
            if(i != 4){
                System.out.print("'" + verb.getVerbForms()[0] + "': " + + maxList[i] + ",");
            }
            if(i == 4){
                System.out.print("'" + verb.getVerbForms()[0] + "': " + + maxList[i]);
            }
        }
    }

    public double getFrequency(int verbIndex){
        double frequency = ((noOfOccurence[verbIndex])) / totalVerbCount;
        return frequency;
    }

    public double calculateDissimilarity(InputDocument other){
        //the higher the dissimilarity the more different the two documents are
        double diff = 0;
        for(int i = 0; i < verbDictionary.getVerbList().size(); i++){
            diff += Math.abs((this.getFrequency(i)) - other.getFrequency(i));
        }
        return diff;
    }
}
