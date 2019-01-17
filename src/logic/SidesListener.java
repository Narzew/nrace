package logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author student
 */
public class SidesListener implements KeyListener {

    private ThreadDown threadDown;

    public ThreadDown getThreadDown() {
        return threadDown;
    }

    public void setThreadDown(ThreadDown threadDown) {
        this.threadDown = threadDown;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    private int oldInterval;

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            threadDown.left();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            threadDown.right();
        }
        //Przyśpieszenie opuszczania
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            RaceSettings.interval -=10 ;
        }
        // Zwolnienie
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            RaceSettings.interval += 10;
            if(RaceSettings.interval>RaceSettings.min_interval){
                RaceSettings.interval = RaceSettings.min_interval;
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){}

}
