/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Rectangle;
import pkg2dgamesframework.Objects;

/**
 *
 * @author DonQuixote
 */
public class Chimney extends Objects{
    
    private boolean isAlive=true;
    
    private Rectangle rect;
    
    private boolean isBehindBird = false;
    
    public Chimney(int x, int y, int w, int h){
        super(x,y,w,h);
        rect = new Rectangle(x,y,30,30);
    }
    
    public void update(){
        if(getPosY()>1000) setLive(false);
        setPosY(getPosY()+2);
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
