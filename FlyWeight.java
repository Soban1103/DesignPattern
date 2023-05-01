package Structural;
// Fly Weight Pattern

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class BallFlyWeight{
    String colour;
    int radius;
    
    public BallFlyWeight(String colour,int radius){
        System.out.println("FlyWeight Object : Type " + colour + " created!!");
        this.colour = colour;
        this.radius = radius;
    }    
}   

class Ball{
    
    int x;
    int y;
    String Patternchoice;

    BallFlyWeight bf;

    public Ball(BallFlyWeight bf){
        this.bf = bf;
    }
    public void drawBall(int x,int y, String Patternchoice){
        this.x=x;
        this.y=y;
        this.Patternchoice = Patternchoice;
        System.out.println("Ball is drawn of colour " + bf.colour + " at X " + x + " and Y " + y + " position filled with " + Patternchoice);        
    }
}

class BallFactory{
    
    Map<String,BallFlyWeight> bm = new HashMap<String,BallFlyWeight>();

    BallFlyWeight bfw = null;

    public BallFlyWeight createBall(String colour){

        if (colour.equalsIgnoreCase("yellow")) {
            bfw = new BallFlyWeight("yellow", 5);
        }else if (colour.equalsIgnoreCase("red")) {
            bfw = new BallFlyWeight("red", 3);
        }else{
            System.out.println("Invalid Input!!!");
        }
        
        bm.put(colour, bfw);            
        return bfw;
    }

}

public class FlyWeight {
    public static void main(String[] args) {
        String[] patterns = {"dotted", "line", "cross", "wavyLines"};
        BallFactory bf = new BallFactory();
        
        BallFlyWeight bfwr = new BallFlyWeight("red", 3);
        BallFlyWeight bfwy = new BallFlyWeight("yellow", 5);
        
        Ball b1 = new Ball(bfwy);
        Ball b2 = new Ball(bfwr);

        ArrayList<Ball> bl = new ArrayList<Ball>();
        ArrayList<Ball>listOfBalls=new ArrayList<Ball>();
        bl.add(b1);
        bl.add(b2);

        Ball b;

        int count = 100;

        for(int i = 0; i < count; i++){
            
            int x = (int) Math.floor(Math.random() *(400+ 1) + 0);
            int y = (int) Math.floor(Math.random() *(200+1) +0);
            int ran = (int)Math.floor(Math.random()*(1+1)+0);
            String pattern = patterns[(int) (Math.random() * patterns.length)];
            
            b = bl.get(ran);
            b.drawBall(x, y, pattern);
            listOfBalls.add(b);
        }  
    }
}
