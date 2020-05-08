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
public class Chimney extends Objects {

    private boolean isAlive = true;

    private Rectangle rect;

    private boolean isBehindBird = false;

    public Chimney(int x, int y, int w, int h) {
        super(x, y, w, h);
        rect = new Rectangle(x, y, 50, 50);
    }

    public void traject1() {
        setPosY(getPosY() + 2);
    }

    public void traject2() {
        setPosY(getPosY() + 3);
        setPosX(getPosX() + 1);
    }

    public void traject3() {
        setPosY(getPosY() + 3);
        setPosX(getPosX() - 1);
    }

    public void update(int traject) {
        if (getPosY() > 1500 || getPosX() < -50 || getPosX() > 1000) {
            setLive(false);
        }
//        for (int i = 0; i < GroupBullet.getSize(); i++) {
//            if (getRect().intersects(GroupBullet.getBullet(i).getRect())) {
//                setLive(false);
//            }
//        }
        if(getAlive()==true)
        if (traject == 0) {
            traject1();
        } else if (traject == 1) {
            traject2();
        } else if (traject == 2) {
            traject3();
        }

        rect.setLocation((int) this.getPosX(), (int) this.getPosY());
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setIsBehindBird(boolean b) {
        isBehindBird = b;
    }

    public boolean getIsBehindBird() {
        return isBehindBird;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setLive(boolean b) {
        isAlive = b;
    }

}
