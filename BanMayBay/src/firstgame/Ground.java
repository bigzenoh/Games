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

/**
 *
 * @author DonQuixote
 */
public class Ground {
    
    private BufferedImage groundImage;
    
    private int x1, y1, x2, y2;
    
    public Ground(){
        try {
            groundImage = ImageIO.read(new File("Assets/sky2.png"));
        } catch (IOException ex) {}
        
        x1 = 0;
        y1 = -1000;
        x2 = 0;
        y2 = y1-3000;
        
    }
    
    public void Update(){
        y1+=1;

        if(y1>0) y1=-2000;
    }

    public  void Paint(Graphics2D g2){
        g2.drawImage(groundImage,x1,y1,null);
    }
    
    public int getY(){
        return y1;
    }

}
