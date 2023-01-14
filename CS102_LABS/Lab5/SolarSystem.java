package Lab5;

import javax.swing.JFrame;

public class SolarSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlanetPanel planetPanel = new PlanetPanel();
        frame.getContentPane().add(planetPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
