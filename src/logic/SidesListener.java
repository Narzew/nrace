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
        if (e.getKeyCode() == 37) {
            threadDown.left();
        }
        if (e.getKeyCode() == 39) {
            threadDown.right();
        }
        //Przyśpieszenie opuszczania
        if (e.getKeyCode() == 40) {
            if (RaceSettings.interval % 10 == 0) {
                oldInterval = RaceSettings.interval;
            }
            RaceSettings.interval = 55;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Przyśpieszenie opuszczania
        if (e.getKeyCode() == 40) {
            RaceSettings.interval = oldInterval;
        }
    }

}
