/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author DonQuixote
 */
public class BulletGroup {

//    int SIZE = 0, deadSIZE = 0;
    ArrayList<Bullet> bullets;
    ArrayList<Bullet> deadBullets;

    public BulletGroup() {

        bullets = new ArrayList<Bullet>();
        deadBullets = new ArrayList<>();
//        Bullet b;
//        b = new Bullet(Bird.getX(), Bird.getY(), 20, 20);
        bullets.add(null);
        deadBullets.add(null);
//        SIZE++;

    }

    public void update() {

        for (int i = 0; i <bullets.size()-1; i++) {
            if (bullets.get(i).getAlive() == true) {
                System.out.println("alive " + i);
                bullets.get(i).update();

            } else {
                deadBullets.add(bullets.get(i));
//                deadSIZE++;
            }

//            System.out.println(bullets.get(i).getPosY());
        }
        bullets.removeAll(deadBullets);
//        SIZE -= deadSIZE;
//        deadSIZE = 0;
        deadBullets.clear();
//        System.out.println("================");
    }

    public void paint(Graphics2D g2) {
        for (int i = 0; i < bullets.size(); i++) {
            g2.setColor(Color.red);
            g2.fillRect((int) bullets.get(i).getPosX(), (int) bullets.get(i).getPosY(), 20, 20);
        }

    }

    public void fire() {
        Bullet b;
        b = new Bullet(Bird.getX(), Bird.getY(), 20, 20);
        bullets.add(b);
//        SIZE++;
    }

    public void reset() {
        bullets.clear();
    }

}
