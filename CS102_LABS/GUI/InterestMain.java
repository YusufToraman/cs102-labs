package GUI;

import javax.swing.JFrame;

public class InterestMain {
    public static void main(String[] args) {
        JFrame frame = new InterestBalance();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
