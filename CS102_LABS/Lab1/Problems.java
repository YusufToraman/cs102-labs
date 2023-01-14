public class Problems {
    private int x;
    private int y;
    private int z;
    private int a;
    private int b;

    public Problems(int _x, int _y, int _z, int _a, int _b){
        x = _x;
        y = _y;
        z = _z;
        a = _a;
        b = _b;
    }

    // Overload constructor for 1. and 3. questions
    public Problems(int _x, int _y){
        x = _x;
        y = _y;
    }

    public String divisibleProblemResult(){

        if(MathOperations.divisibleBy(x, y, z, a, b).size() == 0){
            return "This problem is unsolveable because any number between [" + a + ", " + b + 
            "] is not divisible by " + x + ", " + y + " and " + z;

        }

        else{
            return "The numbers that divisible by " + x + ", " + y + ", " + z + " are: " + MathOperations.divisibleBy(x, y, z, a, b);
        }
    }

    public String roseProblemResult(){
        return "Step 1: For getting the distance between each rose we should find the gcd of 2 numbers \n" + 
        "Step 2: " + x + " and " + y + " 's gcd should be found \nFrom the gcd algorithm " + MathOperations.gcdRoseAlgorithm(x, y) 
        + " meter distance should be between the roses";
    }

    public String doubleAgeProblemResult(){

        if(MathOperations.doubleAlgorithm(x, y) == -1){
            return "This problem is unsolveable because 2 * " + y + " is already bigger than " + x;
        }
        
        else{
            return "Step 1: Multiply 2 with daughter's age and add C constant which shows year\n" + 
            "Step 2: Then, for getting C create equation 2 * (" + y + " + C) = " + x + " + C\n" + 
            "From the equation, after " + MathOperations.doubleAlgorithm(x, y) + 
            " years Louise be double her daughter’s age";
        }
    }
}
