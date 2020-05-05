/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pkg2dgamesframework.QueueList;

/**
 *
 * @author DonQuixote
 */
public class ChimneyGroup {
    
    
    
    private QueueList<Chimney> chimneys;
    
    private BufferedImage chimneyImage, chimneyImage2;
    
    public static int SIZE = 6;
    
    public Chimney getChimney(int i){
        return chimneys.get(i);
    }
    
    public ChimneyGroup(){
        chimneys = new QueueList<Chimney>();
        
        try {
            chimneyImage = ImageIO.read(new File("Assets/chimney.png"));
            chimneyImage2 = ImageIO.read(new File("Assets/chimney2.png"));
        } catch (IOException ex) {}
        
        Chimney cn;
        for(int i=0;i<SIZE/2;i++){
            
            cn = new Chimney(830+i*300, 350, 74, 400);
            chimneys.push(cn);
            cn = new Chimney(830+i*300, -300, 74, 400);
            chimneys.push(cn);
        }
    }
    public void update(){
        if(chimneys.get(0).getPosX()<-74){
          Chimney cn;
            cn = chimneys.pop();
            cn.setPosX(chimneys.get(4).getPosX()+300);
            cn.setIsBehindBird(false);
            chimneys.push(cn);
            
            cn = chimneys.pop();
            cn.setPosX(chimneys.get(4).getPosX());
            chimneys.push(cn);
        }
        
        for(int i=0;i<6;i++){
            chimneys.get(i).update();
        }
        
        
    }

    public void paint(Graphics2D g2){
        for(int i=0;i<6;i++){
            if(i%2==0)
                g2.drawImage(chimneyImage, (int)chimneys.get(i).getPosX(),(int) chimneys.get(i).getPosY(), null);
            else 
                g2.drawImage(chimneyImage2, (int)chimneys.get(i).getPosX(),(int) chimneys.get(i).getPosY(), null);
        }
    }

    public void reset(){
        Chimney cn;
        for(int i=0;i<SIZE/2;i++){
            
            chimneys.pop();
            cn = new Chimney(830+i*300, 350, 74, 400);
            chimneys.push(cn);
            chimneys.pop();
            cn = new Chimney(830+i*300, -300, 74, 400);
            chimneys.push(cn);
        }
        
    }
}
