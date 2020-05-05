/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pkg2dgamesframework.AFrameOnImage;
import pkg2dgamesframework.Animation;
import pkg2dgamesframework.Objects;

/**
 *
 * @author DonQuixote
 */
public class Bird extends Objects{
    
    private int x, y, w, h;
    private BufferedImage birds;
    Animation bird_anim;
    
    
    private float vt = 0;
    private float horizon_left = 0, horizon_right =0;
    private float vertical_up = 0, vertical_down = 0;
    
    private Rectangle rect;
    private boolean isAlive = true;
    
    
    public Bird(){
          
        x = 0;
        y = 0;
        w = 50;
        h = 50;
        
        rect = new Rectangle(x,y,50,50);
        
        
        try {
            birds = ImageIO.read(new File("Assets/plane.png"));
        } catch (IOException ex) {} 
        //khoi tao hieu ung chuyen dong cua may bay
        bird_anim = new Animation(70);
        AFrameOnImage f;
        f = new AFrameOnImage(0, 0, 60, 60);
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(60, 0, 60, 60);
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(120, 0, 60, 60);
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(60, 0, 60, 60);//them 4 frame vao mang
        bird_anim.AddFrame(f);
        //khoi tao may bay
    }
    
    public void setLive(boolean b){
        isAlive = b;
    }
    public boolean getAlive(){
//        if(isAlive==true)System.out.println("still Alive");
        return isAlive;
    }
    
    public Rectangle getRect(){
        return rect;
    }


    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    public void setPos(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public void setVt(float vt){
        this.vt = vt;
    }
    
    public  void update(long deltaTime){
        
        float g = 0.3f; //gia toc  roi
        
        if(isAlive) bird_anim.Update_Me(deltaTime);
        vt+=g;

        
          if(y>0) y+=vertical_up;
          if(y<940) y+=vertical_down;
          if(x>0) x+=horizon_left;
          if(x<940)x+=horizon_right;
        if(!isAlive) x-=2;
        this.rect.setLocation(this.x, this.y);
    } 
    
//    public void fly(){
//        vt=-5;
//    }
    public void turnLeft(){
        horizon_left=-5;
    }
    public void notTurnLeft(){
        horizon_left=0;
    }
    public void turnRight(){
        horizon_right=5;
    }
    public void notTurnRight(){
        horizon_right=0;
    }
    public void turnUp(){
        vertical_up=-5;
    }
    public void notTurnUp(){
        vertical_up=0;
    }
    public void turnDown(){
        vertical_down=5;
    }
    public void notTurnDown(){
        vertical_down=0;
    }

    
    @Override
    public float getH() {
    return h;
    }
    
    public void paint(Graphics2D g2){
        
        if(horizon_left<0)
            bird_anim.PaintAnims(x, y, birds, g2, 0, (float) -0.4);
        else if(horizon_left==0 && horizon_right==0)
            bird_anim.PaintAnims(x, y, birds, g2, 0, 0);
        else if(horizon_right>0)
            bird_anim.PaintAnims(x, y, birds, g2, 0, (float)0.4);
    }
    
}
