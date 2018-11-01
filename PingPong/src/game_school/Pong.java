
package game_school;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pong {
    private int X;
    private int Rect_Width;
    private int Rect_Height;
    private int Y;
    
    public Pong(int WIDTH, int HEIGHT , int y){
        setY(y);
        setHEIGHT(HEIGHT);
        setWIDTH(WIDTH);
        
        
    }
    public int getX(){
        return this.X;
    }
    public void setX(int newX){
        this.X = newX;
    }
    public int getY(){
        return this.Y;
    }
    public void setY(int newY){
        this.Y = newY;
    }
    public int getWIDTH(){
        return this.Rect_Width;
    }
    public int getHEIGHT(){
        return this.Rect_Height;
    }
    public void setWIDTH(int WIDTH){
        this.Rect_Width = WIDTH;
    }
    public void setHEIGHT(int HEIGHT){
        this.Rect_Height = HEIGHT;
    }
    
}
