/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Player extends HComponent {
    public int pos_x = 10;
    public int pos_y = (576/2) - 50;
    protected int paddle_width = 10;
    protected int paddle_height= 100;
    
    public Player(int x,int y, int h, int w){
        this.setBounds(x,y, h, w); 
    }
    
    // Paint methode overschrijven
    public void paint ( Graphics g ) {
        g.setColor(new DVBColor(255,255,255,255)); 
        g.fillRect(pos_x, pos_y, paddle_width , paddle_height);
    } 
}
