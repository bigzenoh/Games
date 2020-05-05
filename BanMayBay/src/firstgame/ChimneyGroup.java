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
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pkg2dgamesframework.QueueList;

/**
 *
 * @author DonQuixote
 */
public class ChimneyGroup {
    
        Random generator = new Random();

    private QueueList<Chimney> chimneys;

    private BufferedImage chimneyImage, chimneyImage2;

    public static int SIZE = 60;
    
    int[] trajects = new int[SIZE];
    
    public Chimney getChimney(int i) {
        return chimneys.get(i);
    }

    public ChimneyGroup() {
        
        chimneys = new QueueList<Chimney>();

        try {
            chimneyImage = ImageIO.read(new File("Assets/enemyplane.png"));
            chimneyImage2 = ImageIO.read(new File("Assets/chimney2.png"));
        } catch (IOException ex) {
        }

        Chimney cn;
        for (int i = 0; i < SIZE / 4; i++) {

            cn = new Chimney(generator.nextInt(1000),generator.nextInt(2000)-2000, 50, 50);
            chimneys.push(cn);
            cn = new Chimney(generator.nextInt(1000), generator.nextInt(2000)-2000, 50, 50);
            chimneys.push(cn);
            cn = new Chimney(generator.nextInt(1000), generator.nextInt(2000)-2000, 50, 50);
            chimneys.push(cn);
            cn = new Chimney(generator.nextInt(1000),generator.nextInt(2000)-2000, 50, 50);
            chimneys.push(cn);
        }
        
        for(int i=0;i<SIZE;i++){
            trajects[i]=generator.nextInt(3);
        }
        
    }

    public void update() {
        for(int i=0;i<SIZE;i++)
            if (chimneys.get(i).getAlive()==false) {

//            Chimney cn;
//            
//            cn = chimneys.pop();
            chimneys.get(i).setPosX(generator.nextInt(1000));
            chimneys.get(i).setPosY(generator.nextInt(1000)-1000);
            chimneys.get(i).setLive(true);
            chimneys.get(i).setIsBehindBird(true);
//            chimneys.push(cn);

        }

        for (int i = 0; i < SIZE; i++) {
            chimneys.get(i).update(trajects[i]);
        }

    }

    public void paint(Graphics2D g2) {
        for (int i = 0; i < SIZE; i++) {
            
                g2.drawImage(chimneyImage, (int)chimneys.get(i).getPosX(),(int) chimneys.get(i).getPosY(), null);
//            g2.setColor(Color.red);
//            g2.fillRect((int) chimneys.get(i).getPosX(), (int) chimneys.get(i).getPosY(), 50, 50);
        }
    }

    public void reset() {
        Chimney cn;
        for (int i = 0; i < SIZE / 4; i++) {

            chimneys.pop();
            cn = new Chimney(generator.nextInt(1000),generator.nextInt(2000)-2000, 50, 50);
            chimneys.push(cn);
            chimneys.pop();
            cn = new Chimney(generator.nextInt(1000), generator.nextInt(2000)-2000, 50, 50);
            chimneys.push(cn);
            chimneys.pop();
            cn = new Chimney(generator.nextInt(1000), generator.nextInt(2000)-2000, 50, 50);
            chimneys.push(cn);
            chimneys.pop();
            cn = new Chimney(generator.nextInt(1000),generator.nextInt(2000)-2000, 50, 50);
            chimneys.push(cn);
        }

    }
}
