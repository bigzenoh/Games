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
    
    
    
    private Bird bird;
    private Ground ground;
    private ChimneyGroup chimneyGroup ;
    
    private int point = 0;
    
    private int BEGIN_SCREEN = 0;
    private int GAMEPPLAY_SCREEN = 1;
    private int GAMEOVER_SCREEN = 2;
    
    private int CurrentScreen = BEGIN_SCREEN;
    
    public FirstGame() {
        super(1000,1000);
        
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
        bird.setPos(470,800);
        bird.setVt(0);
        bird.setLive(true);
        chimneyGroup.reset();
        point = 0;
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////UPDATE///
    @Override
    public void GAME_UPDATE(long deltaTime) {
        
        if(CurrentScreen == BEGIN_SCREEN) {
            resetGame();
        } else if(CurrentScreen == GAMEPPLAY_SCREEN) {

            bird.update(deltaTime);
            
            ground.Update();   
            
            chimneyGroup.update();
            
            for(int i=0;i<chimneyGroup.SIZE;i++){
                if(bird.getRect().intersects(chimneyGroup.getChimney(i).getRect())){
                    bird.setLive(false);
                    System.out.println("set Alive False");
                }
                
                    
            }
            
            for(int i=0;i<chimneyGroup.SIZE;i++){
                if(chimneyGroup.getChimney(i).getIsBehindBird()==true){
                    point++;
                    chimneyGroup.getChimney(i).setIsBehindBird(false);
                    
            }
            }
            
            if(bird.getAlive() == false)
                CurrentScreen = GAMEOVER_SCREEN;
        }
        
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////PAINT//
    @Override
    public void GAME_PAINT(Graphics2D g2) {
        
        ground.Paint(g2);
        chimneyGroup.paint(g2);
        bird.paint(g2);   
        
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////KEY_EVENT///
    
    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
        if(Event == KEY_PRESSED && e.getKeyCode()==KeyEvent.VK_SPACE){
//            
            if(CurrentScreen == BEGIN_SCREEN){
                CurrentScreen = GAMEPPLAY_SCREEN;
                
            } else if(CurrentScreen == GAMEOVER_SCREEN)
                CurrentScreen = BEGIN_SCREEN;
        }
        if(e.getKeyCode() == KeyEvent.VK_A && Event == KEY_PRESSED){
                if(bird.getAlive()) bird.turnLeft();
        } else if(e.getKeyCode() == KeyEvent.VK_A && Event == KEY_RELEASED) bird.notTurnLeft();
        
        if(e.getKeyCode() == KeyEvent.VK_D && Event == KEY_PRESSED){
            if(bird.getAlive()) bird.turnRight();
        } else if(e.getKeyCode() == KeyEvent.VK_D && Event == KEY_RELEASED) bird.notTurnRight();
        
        if(e.getKeyCode() == KeyEvent.VK_W && Event == KEY_PRESSED){
            if(bird.getAlive()) bird.turnUp();
        } else if(e.getKeyCode() == KeyEvent.VK_W && Event == KEY_RELEASED) bird.notTurnUp();
        
        if(e.getKeyCode() == KeyEvent.VK_S && Event == KEY_PRESSED){
            if(bird.getAlive()) bird.turnDown();
        } else if(e.getKeyCode() == KeyEvent.VK_S && Event == KEY_RELEASED) bird.notTurnDown();
        

    }
    
}
