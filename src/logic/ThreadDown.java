package logic;

import data.Vehicle;
import data.Race;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class ThreadDown extends Thread {

    private Component component;

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    private Race race;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    private Vehicle block;

    public Vehicle getVehicle() {
        return block;
    }

    public void setVehicle(Vehicle block) {
        this.block = block;
    }

    private int w, k;

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public void left() {
        race.clear(w, k, block.getTable());
        if (race.isPlace(w, k - 1, block.getTable())) {
            k--;
        }
        race.draw(w, k, block.getTable());
        component.repaint();
    }

    public void right() {
        race.clear(w, k, block.getTable());
        if (race.isPlace(w, k + 1, block.getTable())) {
            k++;
        }
        race.draw(w, k, block.getTable());
        component.repaint();
    }

    private int interval;

    public void initializeRace(){
        int blockHeight;
        block = new Vehicle();
        int c = (int) (Math.random() * 5);
        blockHeight = block.getTable().length;
        w = RaceSettings.rowCount - blockHeight;
        k = RaceSettings.colCount / 2;
        race.draw(w, k, block.getTable());
        component.repaint();
    }
    
    @Override
    public void run() {
       initializeRace();
        // Dopóki trwa wyścig
        while (race.isEmpty(3)) {
            // Move the whole board down
            interval = RaceSettings.interval;
            try {
                Thread.sleep(interval);
            } catch (InterruptedException ex) {
                return;
            }
            race.moveDown(25);
            race.clear(w, k, block.getTable());
            while (race.isPlace(w + 1, k, block.getTable())) {
                w++;
                race.draw(w, k, block.getTable());
                component.repaint();
                interval = RaceSettings.interval;
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException ex) {
                    return;
                }
                race.clear(w, k, block.getTable());
            }
            race.draw(w, k, block.getTable());
            race.delete();
            component.repaint();
        }
        //Zakończenie gry
        block.setTable(new boolean[1][1]);
        race.clear();
        JOptionPane.showMessageDialog(null, "KONEC GRY!!!\nTWÓJ WYNIK "+RaceSettings.score,"KONIEC",JOptionPane.PLAIN_MESSAGE);
    }

}
