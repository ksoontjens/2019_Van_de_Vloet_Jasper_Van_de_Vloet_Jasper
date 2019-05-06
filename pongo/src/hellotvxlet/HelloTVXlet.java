package hellotvxlet;

import java.awt.Color;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;


public class HelloTVXlet implements Xlet, UserEventListener {

  HScene scene;
  
  int player_points = 0;
  int enemy_points  = 0;
  
  int paddle_height = 100;
  int field_height  = 576;
  int field_width   = 720;
  
  Player player;
  Ball ball;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
     //720 x 576
     //x,y,width,heigth in px
        
     player = new Player (20,0, field_width, field_height);
     ball = new Ball (0,0, field_width, field_height);
     
     scene = HSceneFactory.getInstance().getDefaultHScene();
     scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
     scene.setBackground(Color.BLACK);
     
     HStaticText score_player= new HStaticText(Integer.toString(player_points), 200, 10, 50, 50);  
     
     HStaticText score_enemy= new HStaticText(Integer.toString(enemy_points), 470, 10, 50, 50);
    
     scene.add(score_player);
     scene.add(score_enemy);
     scene.add(player);
     scene.add(ball);
     scene.validate();
     scene.setVisible(true);
     
     UserEventRepository rep = new UserEventRepository("naam");
     rep.addAllArrowKeys();
     EventManager.getInstance().addUserEventListener(this, rep);
     
     player.pos_y = 200;
     runGame();
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void userEventReceived(UserEvent e) {
        if(e.getCode() == HRcEvent.VK_UP && player.pos_y>0){
            player.pos_y-=10;
            player.repaint();
        }
        if(e.getCode() == HRcEvent.VK_DOWN && player.pos_y<(field_height - paddle_height)){
            player.pos_y+=10;
            player.repaint();
            
        }
    }
    
    public void runGame(){
        while(true){
         ball.move();
         ball.repaint();
         checkCollision();
         
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void checkCollision(){
        if(ball.pos_x - ball.radius == player.pos_x){
           if(ball.pos_y >= player.pos_y - 50   ){
                ball.direction_x = true;
            }
        }
    }
}
