
package game_school;

import javafx.scene.paint.Color;

import javafx.scene.shape.Ellipse;


public class Ball {
    private final Color color = Color.WHITE;
    private double Diameter = 2.;
    private int x = 0;
    private int y = 0;
    
    
    public Ball(int X , int Y, Double Diameter){
        setX(X);
        setY(Y);
        setDiameter(Diameter);
}
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int newX){
        this.x = newX;
    }
    public void setY(int newY){
        this.y = newY;
    }
    public void setDiameter(double newDiameter){
        this.Diameter = newDiameter;
    }
    public double getDiameter(){
        return this.Diameter;
    }
}
