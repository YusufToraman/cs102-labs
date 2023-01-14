package Lab5;
import java.awt.*;
import javax.swing.JComponent;

//(x, y) = (acos(alfa) + bsin(alfa))
public class Planet extends JComponent{
    private double a;
    private double b;
    private int planetR;
    private double x;
    private double y;
    private double w;
    private double theta;
    private String color;

    public Planet(int planetR, double _a, double _b, double _theta, double _w, String color){
        this.planetR = planetR;
        a = _a;
        b = _b;
        theta = _theta;
        w = _w;
        this.color = color;
    }

    public void setPosition(double angel){
        x = 250 + Math.cos(theta) * a;
        y = 255 + Math.sin(theta) * b;
    }

    public void draw(Graphics g){

        if(color.equals("pink")) 
            g.setColor(Color.pink);
        if(color.equals("red")) 
            g.setColor(Color.red);
        if(color.equals("blue"))
            g.setColor(Color.blue);
        if(color.equals("green")) 
            g.setColor(Color.green);
        if(color.equals("white"))
            g.setColor(Color.white);
        if(color.equals("orange")) 
            g.setColor(Color.orange);
        if(color.equals("yellow"))
            g.setColor(Color.yellow);

        g.fillOval((int)x, (int)y, planetR, planetR);
        g.setColor(Color.gray);
        g.drawOval((int)(275 - a - 5), (int)(250 - b + 15), (int)(a * 2), (int)(b * 2));
    }

    public double getW(){
        return this.w;
    }

    public double getTheta(){
        return this.theta;
    }

    public void setTheta(double angel){
        theta = angel;
    }

    public double getA(){
        return this.a;
    }

    public double getB(){
        return this.b;
    }

    public String getColor(){
        return color;
    }
}
