/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Score extends HComponent{
    
    public int player1;
    public int player2;
    
    public String label;
    
    public Score(int x,int y, int h, int w){
        this.setBounds(x,y, h, w); 
    }
    
    // Paint methode overschrijven
    public void paint ( Graphics g ) {
        g.setColor(Color.WHITE); 
        label = Integer.toString(player1) + "                                   " + Integer.toString(player2);
        g.drawString(label, 20  , 20);
    } 

}
