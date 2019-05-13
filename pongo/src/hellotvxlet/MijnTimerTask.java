/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;

/**
 *
 * @author student
 */
public class MijnTimerTask extends TimerTask {

    HelloTVXlet htvx;
    public MijnTimerTask(HelloTVXlet htvx)
    {
        this.htvx=htvx;
    }
    public void run() {
        htvx.runGame();
    }

}
