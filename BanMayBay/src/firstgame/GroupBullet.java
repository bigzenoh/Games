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
    long prevTime = System.currentTimeMillis();
    private Bird bird;

    public static int SIZE = 30;

    public static Bullet getBullet(int i) {
        return bullets.get(i);
    }
    
    public static int getSize(){
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
        if(bullets.getSize()<SIZE)
        if (System.currentTimeMillis() - prevTime >= 200) {
            Bullet b;
            b = new Bullet(Bird.getX(), Bird.getY(), 20, 20);
            bullets.push(b);
            prevTime = System.currentTimeMillis();
        }

        for (int i = 0; i < bullets.getSize() - 1; i++) {
//            for(int j=0;j<bullets.getSize();j++)
//                    if(ChimneyGroup.getChimney(i).getRect().intersects(bullets.get(j).getRect())){
//                        ChimneyGroup.getChimney(i).setLive(false);
//                        bullets.get(i).setLive(false);
//                    }
            
            if (bullets.get(i).getAlive() == false) {
                bullets.get(i).setPos(bird.getX(), bird.getY());
                bullets.get(i).setLive(true);
            }
                
                        
                bullets.get(i).update();
            
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

    public void reset() {
        Bullet b;
        for (int i = 0; i < SIZE / 4; i++) {

            bullets.pop();
            b = new Bullet(bird.getX(), bird.getY(), 2, 2);
            bullets.push(b);
            bullets.pop();
            b = new Bullet(bird.getX(), bird.getY(), 2, 2);
            bullets.push(b);
            bullets.pop();
            b = new Bullet(bird.getX(), bird.getY(), 2, 2);
            bullets.push(b);
            bullets.pop();
            b = new Bullet(bird.getX(), bird.getY(), 2, 2);
            bullets.push(b);
        }

    }

}
