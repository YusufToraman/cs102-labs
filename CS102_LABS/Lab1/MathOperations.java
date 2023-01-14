import java.util.ArrayList;
import java.util.Random;

public class MathOperations {

    // Math operation for finding whole numbers between A and B that are divisible by X, Y, and Z.
    public static ArrayList<Integer> divisibleBy(int x, int y, int z, int a, int b){
        ArrayList<Integer> list = new ArrayList<>();

        // Determine the interval
        int max = 0;
        int min = 0;
        if(b > a){
            max = b;
            min = a;
        }
        else{
            max = a;
            min = b;
        }

        // Add each value that provides the rule to the ArrayList
        for(int i = min; i <= max; i++){
            if(i % x == 0 && i % y == 0 && i % z == 0){
                list.add(i);
            }
        }
        return list;
    }

    public static int gcdRoseAlgorithm(int a, int b){

        int gcd = 1;
        int lessOne = -1;
        if(a > b){
            lessOne = b;
        }
        else{
            lessOne = a;
        }
        for(int i = 1; i <= lessOne; i++){
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }

        return gcd;
    }

    public static int doubleAlgorithm(int x, int y){

        int result = 0;

        // 2y + c = x
        if(x < 2 * y){
            // Unsolveable condition
            return -1;
        }
        else{
            for(int i = 0; 2 * (y + i - 1) != x + i - 1; i++){
                if((2 * (y + i) == x + i)){
                    result = i;
                }
            }
        }

        return result;
    }

    public static int getRandomInput(){
        Random rand = new Random();
        int random = rand.nextInt(10, 100);
        return random;
    }
}
