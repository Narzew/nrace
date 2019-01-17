package logic;

import data.Race;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class RaceAction {
    private Race race;
    
    public void createRace(){
        race = new Race(RaceSettings.rowCount, RaceSettings.colCount);
        race.putRandomVehicles();
        race.delete();
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
    
    Component component;

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
    
    private ThreadDown threadDown;

    public ThreadDown getThreadDown() {
        return threadDown;
    }

    public void setThreadDown(ThreadDown threadDown) {
        this.threadDown = threadDown;
    }
    
    SidesListener sidesListener;

    public SidesListener getSidesListener() {
        return sidesListener;
    }

    public void setSidesListener(SidesListener sidesListener) {
        this.sidesListener = sidesListener;
    }
    
    
    
    public void newGame(){
        if (threadDown != null) {
            threadDown.interrupt();
        }
                
        threadDown = new ThreadDown();
        threadDown.setComponent(component);
        createRace();
        threadDown.setRace(race);
        sidesListener.setThreadDown(threadDown);
        threadDown.start();
    }
}
