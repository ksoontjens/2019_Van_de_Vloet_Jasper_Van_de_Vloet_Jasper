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
public class Player extends HComponent {
    
    protected int paddle_width = 10;
    protected int paddle_height= 100;
    
    public int pos_x;
    public int pos_y;
    public int score = 0;
    
    public Player(int x,int y, int h, int w){
        this.setBounds(x,y, h, w); 
        pos_x = x;
        pos_y = y;
    }
    
    public void paint ( Graphics g ) {
        g.setColor(new DVBColor(255,255,255,255)); 
        g.fillRect(pos_x, pos_y, paddle_width , paddle_height);
    } 
   
}
