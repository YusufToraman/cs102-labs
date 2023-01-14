package Lab2;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        VerbDictionary verbD = new VerbDictionary();
        verbD.processDictionary("Lab2/verbs-dictionaries.txt");

        System.out.println(verbD.findVerbIndex("abandon"));

        //Same word forms will give same result
        System.out.println(verbD.findVerbIndex("drop"));
        System.out.println(verbD.findVerbIndex("dRopPed"));

        // Not found => -1
        System.out.println(verbD.findVerbIndex("Yusuf"));

        System.out.println("*".repeat(100));

        // Create 10 InputDocuments
        InputDocument id0 = new InputDocument("Lab2/Documents/0.txt");
        InputDocument id1 = new InputDocument("Lab2/Documents/1.txt");
        InputDocument id2 = new InputDocument("Lab2/Documents/2.txt");
        InputDocument id3 = new InputDocument("Lab2/Documents/3.txt");
        InputDocument id4 = new InputDocument("Lab2/Documents/4.txt");
        InputDocument id5 = new InputDocument("Lab2/Documents/5.txt");
        InputDocument id6 = new InputDocument("Lab2/Documents/6.txt");
        InputDocument id7 = new InputDocument("Lab2/Documents/7.txt");
        InputDocument id8 = new InputDocument("Lab2/Documents/8.txt");
        InputDocument id9 = new InputDocument("Lab2/Documents/9.txt");

        System.out.println("Top 5 verbs in each document: ");
        System.out.print("0: "); id0.printTop5();
        System.out.println();
        System.out.print("1: "); id1.printTop5();
        System.out.println();
        System.out.print("2: "); id2.printTop5();
        System.out.println();
        System.out.print("3: "); id3.printTop5();
        System.out.println();
        System.out.print("4: "); id4.printTop5();
        System.out.println();
        System.out.print("5: "); id5.printTop5();
        System.out.println();
        System.out.print("6: "); id6.printTop5();
        System.out.println();
        System.out.print("7: "); id7.printTop5();
        System.out.println();
        System.out.print("8: "); id8.printTop5();
        System.out.println();
        System.out.print("9: "); id9.printTop5();

        System.out.println();
        System.out.println("*".repeat(100));

        System.out.println("Dissimilarity Matrix: ");
        System.out.println("N   0    1    2    3    4    5    6    7    8    9");
        System.out.print("0 "); System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f", id0.calculateDissimilarity(id0), id0.calculateDissimilarity(id1), id0.calculateDissimilarity(id2), id0.calculateDissimilarity(id3), id0.calculateDissimilarity(id4), id0.calculateDissimilarity(id5), id0.calculateDissimilarity(id6), id0.calculateDissimilarity(id7), id0.calculateDissimilarity(id8), id0.calculateDissimilarity(id9));
        System.out.println(); 
        System.out.print("1 "); System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f", id1.calculateDissimilarity(id0), id1.calculateDissimilarity(id1), id1.calculateDissimilarity(id2), id1.calculateDissimilarity(id3), id1.calculateDissimilarity(id4), id1.calculateDissimilarity(id5), id1.calculateDissimilarity(id6), id1.calculateDissimilarity(id7), id1.calculateDissimilarity(id8), id1.calculateDissimilarity(id9));
        System.out.println(); 
        System.out.print("2 "); System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f", id2.calculateDissimilarity(id0), id2.calculateDissimilarity(id1), id2.calculateDissimilarity(id2), id2.calculateDissimilarity(id3), id2.calculateDissimilarity(id4), id2.calculateDissimilarity(id5), id2.calculateDissimilarity(id6), id2.calculateDissimilarity(id7), id2.calculateDissimilarity(id8), id2.calculateDissimilarity(id9));
        System.out.println(); 
        System.out.print("3 "); System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f", id3.calculateDissimilarity(id0), id3.calculateDissimilarity(id1), id3.calculateDissimilarity(id2), id3.calculateDissimilarity(id3), id3.calculateDissimilarity(id4), id3.calculateDissimilarity(id5), id3.calculateDissimilarity(id6), id3.calculateDissimilarity(id7), id3.calculateDissimilarity(id8), id3.calculateDissimilarity(id9));
        System.out.println(); 
        System.out.print("4 "); System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f", id4.calculateDissimilarity(id0), id4.calculateDissimilarity(id1), id4.calculateDissimilarity(id2), id4.calculateDissimilarity(id3), id4.calculateDissimilarity(id4), id4.calculateDissimilarity(id5), id4.calculateDissimilarity(id6), id4.calculateDissimilarity(id7), id4.calculateDissimilarity(id8), id4.calculateDissimilarity(id9));
        System.out.println(); 
        System.out.print("5 "); System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f", id5.calculateDissimilarity(id0), id5.calculateDissimilarity(id1), id5.calculateDissimilarity(id2), id5.calculateDissimilarity(id3), id5.calculateDissimilarity(id4), id5.calculateDissimilarity(id5), id5.calculateDissimilarity(id6), id5.calculateDissimilarity(id7), id5.calculateDissimilarity(id8), id5.calculateDissimilarity(id9));
        System.out.println(); 
        System.out.print("6 "); System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f", id6.calculateDissimilarity(id0), id6.calculateDissimilarity(id1), id6.calculateDissimilarity(id2), id6.calculateDissimilarity(id3), id6.calculateDissimilarity(id4), id6.calculateDissimilarity(id5), id6.calculateDissimilarity(id6), id6.calculateDissimilarity(id7), id6.calculateDissimilarity(id8), id6.calculateDissimilarity(id9));
        System.out.println(); 
        System.out.print("7 "); System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f", id7.calculateDissimilarity(id0), id7.calculateDissimilarity(id1), id7.calculateDissimilarity(id2), id7.calculateDissimilarity(id3), id7.calculateDissimilarity(id4), id7.calculateDissimilarity(id5), id7.calculateDissimilarity(id6), id7.calculateDissimilarity(id7), id7.calculateDissimilarity(id8), id7.calculateDissimilarity(id9));
        System.out.println(); 
        System.out.print("8 "); System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f", id8.calculateDissimilarity(id0), id8.calculateDissimilarity(id1), id8.calculateDissimilarity(id2), id8.calculateDissimilarity(id3), id8.calculateDissimilarity(id4), id8.calculateDissimilarity(id5), id8.calculateDissimilarity(id6), id8.calculateDissimilarity(id7), id8.calculateDissimilarity(id8), id8.calculateDissimilarity(id9));
        System.out.println(); 
        System.out.print("9 "); System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f", id9.calculateDissimilarity(id0), id9.calculateDissimilarity(id1), id9.calculateDissimilarity(id2), id9.calculateDissimilarity(id3), id9.calculateDissimilarity(id4), id9.calculateDissimilarity(id5), id9.calculateDissimilarity(id6), id9.calculateDissimilarity(id7), id9.calculateDissimilarity(id8), id9.calculateDissimilarity(id9));
        System.out.println();
        System.out.println("*".repeat(100));

    }
}
