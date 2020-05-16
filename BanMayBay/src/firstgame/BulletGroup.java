/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author DonQuixote
 */
public class BulletGroup {

    private BufferedImage bulletImage;

    ArrayList<Bullet> bullets;
    ArrayList<Bullet> deadBullets;

    public BulletGroup() {

        try {
            bulletImage = ImageIO.read(new File("Assets/1bullet.png"));
        } catch (IOException ex) {
        }

        bullets = new ArrayList<Bullet>();
        deadBullets = new ArrayList<>();

    }

    public void update() {
        if (bullets.size() > 0) {
            for (int i = 0; i < bullets.size(); i++) {
                if (bullets.get(i).getAlive() == true) {
//                    System.out.println("alive " + i);
                    bullets.get(i).update();

                } else {
                    deadBullets.add(bullets.get(i));
                }

            }
            bullets.removeAll(deadBullets);
            deadBullets.clear();
        }

    }

    public void paint(Graphics2D g2) {
        if (bullets.size() > 0) {
            for (int i = 0; i < bullets.size(); i++) {
                g2.drawImage(bulletImage, (int) bullets.get(i).getPosX(), (int) bullets.get(i).getPosY(), null);
            }
        }

    }

    public void fire() {
        Bullet b;
        b = new Bullet(Bird.getX() + 27, Bird.getY(), 20, 20);
        bullets.add(b);
    }

    public void reset() {
        bullets.clear();
    }

}
