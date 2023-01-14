package GUI;

import java.awt.event.*;
import java.util.StringTokenizer;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class InterestBalance extends JFrame{
    private static final double INITIAL_BALANCE = 1000;
    private static final double RATE = 5;
    private JButton withdrawButton;
    private JButton interestButton;
    private JButton depositButton;
    private JTextField amount;
    private JPanel panel;
    private JLabel result;
    private double balance;

    public InterestBalance(){
        setPreferredSize(new Dimension(500, 500));
        balance = INITIAL_BALANCE;
        createComponents();
        add(panel);
    }

    public void createComponents(){
        panel = new JPanel();
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        interestButton = new JButton("Interest");
        result = new JLabel("Balance: " + INITIAL_BALANCE);
        amount = new JTextField("Withdraw/Deposit Amount");

        ActionListener listener = new AddInterestListener();
        ActionListener listener2 = new AddDepositListener();
        interestButton.addActionListener(listener);
        withdrawButton.addActionListener(listener);
        depositButton.addActionListener(listener2);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(amount);
        panel.add(interestButton);
        panel.add(result);
    }

    class AddInterestListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == interestButton){
                double interest = balance * RATE / 100;
                balance += interest;
                result.setText("Balance " + balance);
            }
            else if(e.getSource() == withdrawButton){
                double depoWith = Double.parseDouble(amount.getText());
                balance -= depoWith;
                result.setText("Balance " + balance);
            }
        }    
    }

    class AddDepositListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            double depoWith = Double.parseDouble(amount.getText());
            balance += depoWith;
            result.setText("Balance " + balance);
        }
        
    }
}
