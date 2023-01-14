import java.util.Scanner;
import java.io.*;

public class MainFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print ("Enter your name: ");
        String file = sc.nextLine();
        FileWriter fw = new FileWriter (file);
        BufferedWriter bw = new BufferedWriter (fw);
        PrintWriter outFile = new PrintWriter (bw);

        System.out.println("\n5 Question will be created and the question templates are: \n1) Rose Problem" + 
        "\n2) Division Problem\n3) Age Problem");

        // 5 template will be created
        for(int i = 0; i < 5; i++){
            System.out.print(("Question " + (i + 1) + " template is: "));
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Question " + (i + 1) + ": Around a rectangular flowerbed with dimensions X meters and Y meters are to be planted roses equally spaced so that the roses are found in every corner of the flowerbed and consumed as little as possible. At what distance are planted roses?");
                outFile.println("Question " + (i + 1) + ": Around a rectangular flowerbed with dimensions X meters and Y meters are to be planted roses equally spaced so that the roses are found in every corner of the flowerbed and consumed as little as possible. At what distance are planted roses?");

                int x = MathOperations.getRandomInput(); int y = MathOperations.getRandomInput();
                Problems p = new Problems(x, y);
                outFile.println("Solution " + (i + 1) + ":\n" + p.roseProblemResult());
            }
            if(choice == 2){
                System.out.println(("Question " + (i + 1) + ": Find whole numbers between A and B that are divisible by X, Y, and Z."));
                outFile.println("Question " + (i + 1) + ": Find whole numbers between A and B that are divisible by X, Y, and Z.");

                int x = MathOperations.getRandomInput(); int y = MathOperations.getRandomInput(); int z = MathOperations.getRandomInput(); int a = MathOperations.getRandomInput(); int b = MathOperations.getRandomInput(); 
                Problems p = new Problems(x, y, z, a, b);
                outFile.println("Solution " + (i + 1) + ":\n" + p.divisibleProblemResult());
                
            }
            if(choice == 3){
                System.out.println("Question " + (i + 1) + ": Louise is X years old. Her daughter is Y years old. In how many years will Louise be double her daughter’s age");
                outFile.println("Question " + (i + 1) + ": Louise is X years old. Her daughter is Y years old. In how many years will Louise be double her daughter’s age");

                int x = MathOperations.getRandomInput(); int y = MathOperations.getRandomInput(); 
                Problems p = new Problems(x, y);
                outFile.println("Solution " + (i + 1) + ":\n" + p.doubleAgeProblemResult());
            }
        }

        outFile.close();;
        sc.close();
    }
}

