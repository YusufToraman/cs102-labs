package Lab6;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename = "Lab6/sample_input.txt";
        Facility f = new Facility();
        f.importFacility(filename);
        // f.securityAttack("kkda", 8);
        f.simulateAttack(6);
    }
}
