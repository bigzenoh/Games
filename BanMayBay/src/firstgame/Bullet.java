/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import pkg2dgamesframework.Objects;
//import firstgame.Bird;

/**
 *
 * @author DonQuixote
 */

public class Bullet extends Objects {
    public Bird bird;
    
    private boolean isAlive=true;
    
    private Rectangle rect;
    
    
    
    //contructor
    public Bullet(int x, int y, int w, int h) {
        super(x, y, w, h);
        rect = new Rectangle(x,y,1,1);
    }
    
    
    
//    public void traject1(){
//        setPos(getPosX()+1, getPosY()-6);
//    }
//    public void traject2(){
//        setPosY(getPosY()-2);
//    }
//    public void traject3(){
//        setPos(getPosX()-1, getPosY()-6);
//    }
    
    public void update() {
        if(isAlive==true){
            for(int i=0;i<ChimneyGroup.SIZE;i++)
                    if (isCollisionHappenWith(ChimneyGroup.getChimney(i).getPosX(), ChimneyGroup.getChimney(i).getPosY(), 50, 50)==true)
                    {
                        ChimneyGroup.getChimney(i).setLive(false);
                        setLive(false);
                        System.out.println("Ban trung! "+i);
                    }
        if(getPosY()<0 ) setLive(false);
        setPosY(getPosY()-9);
//        traject2();
//        System.out.println(getPosY());
//        switch (trajects) {
//            case 0:
//                traject1();
//                break;
//            case 1:
//                traject2();
//                break;
//            case 2:
//                traject3();
//                break;
//        }
//        System.out.println(Bird.getX());
//        System.out.println(Bird.getY());
//        setPos(bird.getX(), bird.getY());
        
//        rect.setLocation((int)this.getPosX(),(int) this.getPosY());
//        if (isAlive==false) System.class.
        }
          
        
    }
    
    public boolean getAlive() {
        return isAlive;
    }
    
    public void setLive(boolean b){
        isAlive = b;
    }
    
    public Rectangle getRect(){
        return rect;
    }
    
    
    
    
    public void paint(Graphics2D g2){
        g2.setColor(Color.red);
        g2.fillRect((int)getPosX(),(int) getPosY(), 70, 70);
    }


}
