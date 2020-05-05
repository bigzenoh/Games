/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import pkg2dgamesframework.GameScreen;

/**
 *
 * @author DonQuixote
 */
public class FirstGame extends GameScreen{

//    private BufferedImage birds;
//    private Animation bird_anim;
    
    public static float g = 0.3f; //gia toc  roi
    
    private Bird bird;
    private Ground ground;
    private ChimneyGroup chimneyGroup ;
    
    private int point = 0;
    
    private int BEGIN_SCREEN = 0;
    private int GAMEPPLAY_SCREEN = 1;
    private int GAMEOVER_SCREEN = 2;
    
    private int CurrentScreen = BEGIN_SCREEN;
    
    public FirstGame() {
        super(800,600);
        
        //khoi tao hieu ung chuyen dong cua may bay
//        try {
//            birds = ImageIO.read(new File("Assets/bird_sprite.png"));
//            
//        } catch (IOException ex) {}
//        bird_anim = new Animation(70);
//        AFrameOnImage f;
//        f = new AFrameOnImage(0, 0, 60, 60);
//        bird_anim.AddFrame(f);
//        f = new AFrameOnImage(60, 0, 60, 60);
//        bird_anim.AddFrame(f);
//        f = new AFrameOnImage(120, 0, 60, 60);
//        bird_anim.AddFrame(f);
//        f = new AFrameOnImage(60, 0, 60, 60);//them 4 frame vao mang
//        bird_anim.AddFrame(f);
//        //khoi tao may bay
        bird = new Bird();
        //xong may bay
        ground = new Ground();
        
        chimneyGroup = new ChimneyGroup();
        
        
        
        BeginGame();
    }
    
    
    public static void main(String[] args) {
        new FirstGame();
    }
    
    private void resetGame(){
        bird.setPos(200,250);
        bird.setVt(0);
        bird.setLive(true);
        chimneyGroup.reset();
        point = 0;
    }

    @Override
    public void GAME_UPDATE(long deltaTime) {
        
        if(CurrentScreen == BEGIN_SCREEN) {
            resetGame();
        } else if(CurrentScreen == GAMEPPLAY_SCREEN) {
//            bird_anim.Update_Me(deltaTime);
            bird.update(deltaTime);
            
            ground.Update();   
            
            chimneyGroup.update();
            
            for(int i=0;i<chimneyGroup.SIZE;i++){
                if(bird.getAlive()==true)System.out.println("still Alive");
                else System.out.println("DEAD");
                if(bird.getRect().intersects(chimneyGroup.getChimney(i).getRect())){
                    bird.setLive(false);
                    System.out.println("set Alive False");
                }
                    
                    
            }
            
            for(int i=0;i<chimneyGroup.SIZE;i++){
                if(bird.getX()-36>chimneyGroup.getChimney(i).getPosX() && !chimneyGroup.getChimney(i).getIsBehindBird() && i%2==0){
                    point++;
                    chimneyGroup.getChimney(i).setIsBehindBird(true);
                    
            }
            }
            
            if(bird.getY() + bird.getH() > ground.getY())
                CurrentScreen = GAMEOVER_SCREEN;
        }
        
    }

    @Override
    public void GAME_PAINT(Graphics2D g2) {
 
        chimneyGroup.paint(g2);
        ground.Paint(g2);
        bird.paint(g2);
//        if(bird.getFlying()<0)
//            bird_anim.PaintAnims((int)bird.getPosX(), (int)bird.getPosY(), birds, g2, 0, (float) -0.5);
//        else if(bird.getFlying()==0)
//            bird_anim.PaintAnims((int)bird.getPosX(), (int)bird.getPosY(), birds, g2, 0, 0);
//        else 
//            bird_anim.PaintAnims((int)bird.getPosX(), (int)bird.getPosY(), birds, g2, 0, 1);
//        
        
        if(CurrentScreen == BEGIN_SCREEN) {
            g2.setColor(Color.red);
            g2.drawString("Press space to play this fucking game!", 200, 300);
        }
        if(CurrentScreen == GAMEOVER_SCREEN){
            g2.setColor(Color.red);
            g2.drawString("Ngu loz!", 200, 300);
        }
        g2.setColor(Color.red);
        g2.drawString("Điểm: "+point, 20, 30);
    
    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
        if(Event == KEY_PRESSED){
            
            if(CurrentScreen == BEGIN_SCREEN){
                
                CurrentScreen = GAMEPPLAY_SCREEN;
                
            } else if(CurrentScreen == GAMEPPLAY_SCREEN){
                if(bird.getAlive()) bird.fly();
            } else if(CurrentScreen == GAMEOVER_SCREEN){
                CurrentScreen = BEGIN_SCREEN;
            }
            
        }
    }
    
}
