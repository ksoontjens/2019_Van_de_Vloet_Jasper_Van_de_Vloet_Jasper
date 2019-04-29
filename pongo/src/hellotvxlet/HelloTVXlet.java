package hellotvxlet;

import java.awt.Color;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;


public class HelloTVXlet implements Xlet {

  HScene scene;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      //720 x 576
      //x,y,width,heigth in px
     scene= HSceneFactory.getInstance().getDefaultHScene();
     HStaticText question= new HStaticText("POINTS", 150, 100, 400, 100);
     question.setBackgroundMode(HVisible.BACKGROUND_FILL);
     question.setBackground(Color.BLUE);
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
}
