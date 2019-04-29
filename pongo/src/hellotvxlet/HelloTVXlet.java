package hellotvxlet;

import java.awt.Color;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;


public class HelloTVXlet implements Xlet {

  HScene scene;
  int points_player = 0;
  int points_enemy = 0;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      //720 x 576
      //x,y,width,heigth in px
     scene= HSceneFactory.getInstance().getDefaultHScene();
     scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
     scene.setBackground(Color.BLACK);
     
     HStaticText score_player= new HStaticText(Integer.toString(points_player), 200, 10, 50, 50);  
     
     HStaticText score_enemy= new HStaticText(Integer.toString(points_enemy), 470, 10, 50, 50);
    
     
     scene.add(score_player);
     scene.add(score_enemy);
     scene.validate();
     scene.setVisible(true);
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
}
