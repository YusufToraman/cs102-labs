package Lab5;

import java.util.ArrayList;
import java.awt.event.*;
import java.util.StringTokenizer;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class PlanetPanel extends JPanel{
    private ArrayList<Planet> planetList;
    private JButton playButton;
    private JButton pauseButton;
    private JButton rewindButton;
    private JButton createButton;
    private JTextField newPlanet;
    private Timer clockWiseTimer;
    private Timer counterClockWiseTimer;
    private Image img;

    public PlanetPanel(){

        img = Toolkit.getDefaultToolkit().createImage("space.jpg");
        setBackground(Color.black);
        setPreferredSize(new Dimension(600, 500));

        planetList = new ArrayList<>();
        planetList.add(new Planet(25, 150, 100, 0, 0.01, "blue"));
        planetList.add(new Planet(35, 200, 125, 15, 0.009, "pink"));
        planetList.add(new Planet(30, 175, 115, 0, 0.02, "white"));
        planetList.add(new Planet(20, 250, 150, 0, 0.015, "green"));
        for(int i = 0; i < planetList.size(); i++){
            double angle = planetList.get(i).getTheta();
            angle += planetList.get(i).getW();
            planetList.get(i).setPosition(angle);
        }

        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        rewindButton = new JButton("Rewind");
        createButton = new JButton("Create");

        newPlanet = new JTextField("Enter planetR - a,b - theta - w - color");
        newPlanet.setBounds(140, 30, 400, 30);

        playButton.setBounds(255, 480, 60, 20);
        pauseButton.setBounds(175, 480, 60, 20);
        rewindButton.setBounds(335, 480, 60, 20);
        createButton.setBounds(270, 70, 80, 30);

        playButton.addActionListener(new PlayListener());
        pauseButton.addActionListener(new PauseListener());
        rewindButton.addActionListener(new RewindListener());
        createButton.addActionListener(new CreateListener());

        this.setLayout(null);
        add(playButton);
        add(pauseButton);
        add(rewindButton);
        add(createButton);
        add(newPlanet);

        clockWiseTimer = new Timer(15, new PlayListener());
        counterClockWiseTimer = new Timer(15, new RewindListener());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
        g.setColor(Color.orange);
        g.fillOval(275, 250, 70, 70);
        g.setColor(Color.black);
        for(int i = 0; i < planetList.size(); i++){
            planetList.get(i).draw(g);
        }
    }

    private class PlayListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            counterClockWiseTimer.stop();
            clockWiseTimer.start();
            for(int i = 0; i < planetList.size(); i++){
                planetList.get(i).setTheta(planetList.get(i).getTheta() + planetList.get(i).getW());
                planetList.get(i).setPosition(planetList.get(i).getTheta());
            }
            repaint();
        }
    }
    private class PauseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            counterClockWiseTimer.stop();
            clockWiseTimer.stop();
        }
    }
    private class RewindListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            clockWiseTimer.stop();
            counterClockWiseTimer.start();
            for(int i = 0; i < planetList.size(); i++){
                planetList.get(i).setTheta(planetList.get(i).getTheta() - planetList.get(i).getW());
                planetList.get(i).setPosition(planetList.get(i).getTheta());
            }
            repaint();
        }
    }
    private class CreateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            StringTokenizer st = new StringTokenizer(newPlanet.getText(), " ");
            int planetR = Integer.parseInt(st.nextToken());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double theta = Double.parseDouble(st.nextToken());;
            double w = Double.parseDouble(st.nextToken());
            String color = st.nextToken();
            planetList.add(new Planet(planetR, a, b, theta, w, color));
        }
        
    }
}
