/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Rectangle;
import java.util.Random;
import pkg2dgamesframework.Objects;

/**
 *
 * @author DonQuixote
 */
public class Chimney extends Objects{
    
    Random generator = new Random();
    
    private boolean isAlive=true;
    
    private Rectangle rect;
    
    private boolean isBehindBird = false;
    
    public Chimney(int x, int y, int w, int h){
        super(x,y,w,h);
        rect = new Rectangle(x,y,30,30);
    }
    
    public void traject1(){
        setPosY(getPosY()+2);
    }
    public void traject2(){
        setPosY(getPosY()+3);
        setPosX(getPosX()+1);
    }
    public void traject3(){
        setPosY(getPosY()+3);
        setPosX(getPosX()-1);
    }
    
    public void update(int traject){
        if(getPosY()>1000 || getPosX()<0 || getPosX()>1000) setLive(false);
        int generate = generator.nextInt(3);
        System.out.println(generate);
        if(traject == 0){
            traject1();
        } else if (traject==1){
            traject2();
        }else if(traject==2){
            traject3();
        }
            
//        setPosY(getPosY()+2);
        rect.setLocation((int)this.getPosX(),(int) this.getPosY());
    }
    
    public Rectangle getRect(){
        return rect;
    }
    
    public void setIsBehindBird(boolean b){
        isBehindBird = b;
    }
    
    public boolean getIsBehindBird(){
        return isBehindBird;
    }

    public boolean getAlive() {
        return isAlive;
    }
    
    public void setLive(boolean b){
        isAlive = b;
    }
    
}
