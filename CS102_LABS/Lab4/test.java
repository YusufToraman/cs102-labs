package Lab4;
import java.io.IOException;
public class test {
    public static void main(String[] args) throws IOException {
        Map map = new Map("Lab4/Map2.txt");
        // Bunu check ederken currentPosition ile oynuyo
        map.readFromFolder("Lab4/Paths");
        map.processPaths();
        Path a = new Path("path-2.txt");
        Path b = new Path("path-50.txt");
        System.out.println(map.checkPathCombination(a, b));
        map.processPathCombinations();
    }
}

