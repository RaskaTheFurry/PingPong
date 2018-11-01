/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_school;


import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.animation.Animation;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Random;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Uzivatel
 */
public class PingPongGame extends Application {
    
    private int resolution_X = 800;
    private int resolution_Y = 600;
    private Ball ball1;
    private Ping ping;
    private Pong pong;
    
    
//    private static final int PLAYER_HEIGHT = 100;
//    private static final int PLAYER_WIDTH = 15;
//    private static final double BALL_R = 15;
    private int ballYSpeed = 1;
    private int ballXSpeed = 1;
    private double playerOneYPos = resolution_Y / 2;
    private double playerTwoYPos = resolution_Y / 2;
    private double ballXPos = resolution_X / 2;
    private double ballYPos = resolution_Y / 2;
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private boolean gameStarted;
    private int playerOneXPos = resolution_X/2;
    private Random random = new Random();
    private String test = "";
    private int test2 = 0;
//    private double playerTwoXPos = resolution_X - PLAYER_WIDTH;
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(resolution_X, resolution_Y);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> frame(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        
        
        
//        canvas.setOnMouseMoved(e -> mouseX = e.getX());
        
        ball1 = new Ball(resolution_X/2,resolution_Y/2,20.);
        ping = new Ping(100,20,resolution_Y-20);
        pong = new Pong(50,20,0);
        canvas.setOnMouseMoved(e ->  playerOneXPos  = (int) e.getX()-(ping.getWIDTH()/2));
	canvas.setOnMouseClicked(e ->  gameStarted = true);
        primaryStage.setTitle("Game");
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.show();
        tl.play();
        
        
    }
    private void frame(GraphicsContext gc){
        
        gc.setFill(Color.BLACK);
	gc.fillRect(0, 0, resolution_X, resolution_Y);
	gc.setFill(Color.WHITE);
        
        gc.fillOval(ball1.getX(), ball1.getY(), ball1.getDiameter(), ball1.getDiameter());
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.PINK);
        ping.setX(playerOneXPos+50);
 //       ping.setX(ball1.getX());
        if(ping.getX() >= resolution_X+50){
            ping.setX(resolution_X-ping.getWIDTH()/2);
        }
        if(ping.getX() <= 0+50){
            ping.setX(0+ping.getWIDTH()/2);
        }
        gc.fillRect(ping.getX()-(ping.getWIDTH()/2), ping.getY(), ping.getWIDTH(), ping.getHEIGHT());
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.PINK);
        
//        pong.setX(ball1.getX());
        
        pong.setX(ball1.getX());
        if(pong.getX() >= resolution_X-50){
            pong.setX(resolution_X-ping.getWIDTH()/2);
        }
        if(pong.getX() <= 0+50){
            pong.setX(0+ping.getWIDTH()/2);
        }
        gc.fillRect(pong.getX()-(pong.getWIDTH()/2), pong.getY(), pong.getWIDTH(), pong.getHEIGHT());
         gc.setFill(Color.RED);
        gc.fillRect(ping.getX(), ping.getY(), 5, 5);
//        gc.setFill(Color.RED);
//        
//        gc.fillRect(ball1.getX(), ball1.getY(), 5, 5);
        ball1.setY(ball1.getY()+ballYSpeed);
        System.out.println(pong.getX());
        
        
      ball1.setX(ball1.getX()+ballXSpeed);
        if( (ball1.getY() < pong.getY()+pong.getHEIGHT() && ball1.getX() >= pong.getX()-pong.getWIDTH()/2 && ball1.getX() <= pong.getX() + pong.getWIDTH()/2) || 
		(ball1.getY()+ball1.getDiameter() > ping.getY() && ball1.getX() >= ping.getX()-ping.getHEIGHT()/2 && ball1.getX() <= ping.getX() + ping.getWIDTH()/2)) {
            ballYSpeed = ballYSpeed*-1+ballYSpeed*-1;
            if(ballYSpeed >= 10){
                ballYSpeed = 10;
            }
            if(ballYSpeed <= -10){
                ballYSpeed = -10;
            }
            ballXSpeed = random.nextInt(10)-5;
            
        }
        
        if(ball1.getX() >= resolution_X-20 || ball1.getX() <= 0  ){
            ballXSpeed = ballXSpeed*-1;
        }
        if(ball1.getY()>resolution_Y){
            scoreP2++;
            System.out.println(scoreP2);
            ball1.setY(resolution_Y/2);
            ballYSpeed = 1*-1;
        }
        if(ball1.getY()<0){
            scoreP1++;
            System.out.println(scoreP1);
            ball1.setY(resolution_Y/2);
            ballYSpeed = 1;
        }
        
        gc.fillText("Player1:"+scoreP1 + "\t\t\t\t\t\t\t\t Player2:" + scoreP2, resolution_Y / 2, resolution_X/3);
        //scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, resolution_Y / 2, resolution_X/3
//	gc.setFont(Font.font(25));
//	if(gameStarted) {
//		ballXPos+=ballXSpeed;
//		ballYPos+=ballYSpeed;
//		if(ballXPos < width - width  / 4) {
//			playerTwoYPos = ballYPos - PLAYER_HEIGHT / 2;
//		}  else {
//			playerTwoYPos =  ballYPos > playerTwoYPos + PLAYER_HEIGHT / 2 ?playerTwoYPos += 1: playerTwoYPos - 1;
//		}
//		gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);
//	} else {
//		gc.setStroke(Color.YELLOW);
//		gc.setTextAlign(TextAlignment.CENTER);
//		gc.strokeText("Click to Start", width / 2, height / 2);
//		ballXPos = width / 2;
//		ballYPos = height / 2;
//		ballXSpeed = new Random().nextInt(2) == 0 ? 1: -1;
//		ballYSpeed = new Random().nextInt(2) == 0 ? 1: -1;
//	}
//	if(ballYPos > height || ballYPos < 0) ballYSpeed *=-1;
//	if(ballXPos < playerOneXPos - PLAYER_WIDTH) {
//		scoreP2++;
//		gameStarted = false;
//	}
//	if(ballXPos > playerTwoXPos + PLAYER_WIDTH) {  
//		scoreP1++;
//		gameStarted = false;
//	}
//	if( ((ball1.getY() + ball1.getDiameter() > pong.getY()+pong.getHEIGHT()) && ball1.getX() >= pong.getX() && ball1.getX() <= pong.getX() + pong.getWIDTH()) || 
//		((ball1.getY() < ping.getY() + ping.getHEIGHT()) && ball1.getX() >= ping.getX() && ball1.getX() <= ping.getX() + ping.getWIDTH())) {
//		ballYSpeed += 1 * Math.signum(ballYSpeed);
//		ballXSpeed += 1 * Math.signum(ballXSpeed);
//		ballXSpeed *= -1;
//		ballYSpeed *= -1;
//	}
//	gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
//	gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
//	gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
       

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
