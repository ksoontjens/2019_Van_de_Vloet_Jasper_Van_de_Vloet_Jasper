/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Ball extends HComponent{
    
    public int radius = 20;
    protected int field_x = getWidth();
    protected int field_y = getHeight();
    protected boolean direction_x = true;
    protected boolean direction_y = true;
    
    protected int speed = 2;
    
    public int pos_x;
    public int pos_y;
    
   
    
    public Ball(int x,int y, int h, int w){
        this.setBounds(x,y, h, w); 
        pos_x = x;
        pos_y = y;
        
    }
    
    public void paint ( Graphics g ) {
        g.setColor(new DVBColor(255,255,255,255)); 
        g.fillOval(pos_x, pos_y, radius, radius);
    //    g.fillRect(pos_x, pos_y, 2, 2);
    } 
    
    public void move(){
       //XXXXXXXXXXXXXXX
        
        if(direction_x ==true){
            pos_x += speed;
        }
        if(direction_x== false){
            pos_x -= speed;
        }
        
        if(pos_x == getWidth()- radius){
            direction_x = false;
        }
        
        if(pos_x == 0){
            direction_x = true;
        }
        
       //YYYYYYYYYYYYYYYY
       
        if(direction_y == true){
            pos_y += speed;
        }
        if(direction_y== false){
            pos_y -= speed;
        }
        
        if(pos_y == getHeight()- radius){
            direction_y = false;
        }
        
        if(pos_y == 0){
            direction_y = true;
        }
        
    }
    
}
