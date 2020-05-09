/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg2dgamesframework.QueueList;

/**
 *
 * @author DonQuixote
 */
public class GroupBullet {

    private static QueueList<Bullet> bullets;
    private Bird bird;

    public static int SIZE = 30;

    public static Bullet getBullet(int i) {
        return bullets.get(i);
    }

    public static int getSize() {
        return bullets.getSize();
    }

    public GroupBullet() {

        bullets = new QueueList<Bullet>();

        System.out.println(Bird.getX());
        System.out.println(Bird.getY());

        Bullet b;
        b = new Bullet(Bird.getX(), Bird.getY(), 20, 20);
        bullets.push(b);

    }

    public void update() {


        for (int i = 0; i < bullets.getSize() - 1; i++) {
            if (bullets.get(i).getAlive() == true) {
                System.out.println("alive "+i);
                
                bullets.get(i).update();
            } else 
                remove(i);

//            System.out.println(bullets.get(i).getPosY());
        }
//        System.out.println("================");
    }

    public void paint(Graphics2D g2) {
        for (int i = 0; i < bullets.getSize() - 1; i++) {
            g2.setColor(Color.red);
            g2.fillRect((int) bullets.get(i).getPosX(), (int) bullets.get(i).getPosY(), 20, 20);
        }

    }

    public void fire() {
        Bullet b;
                b = new Bullet(Bird.getX(), Bird.getY(), 20, 20);
                bullets.push(b);
    }

        public void reset() {
//        bullets = null;
          for(int i=0;i<bullets.getSize();i++){
              bullets.pop();
          }
        }

    private void remove(int i) {
        bullets.get(i).setPos(-1000, -1000);
    }

}
