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

    private boolean isAlive = true;

    private Rectangle rect;

    //contructor
    public Bullet(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void update() {
        if (isAlive == true) {
            for (int i = 0; i < ChimneyGroup.SIZE; i++) {
                if (isCollisionHappenWith(ChimneyGroup.getChimney(i).getPosX(), ChimneyGroup.getChimney(i).getPosY(), 50, 50) == true) {
                    Chimney.setIsBehindBird(true);
                    ChimneyGroup.getChimney(i).setLive(false);
                    setLive(false);
//                    System.out.println("Ban trung! " + i);
                }
            }
            if (getPosY() < 0) {
                setLive(false);
            }
            setPosY(getPosY() - 9);
        }

    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setLive(boolean b) {
        isAlive = b;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void paint(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.fillRect((int) getPosX(), (int) getPosY(), 70, 70);
    }

}
