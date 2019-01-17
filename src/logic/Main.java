package logic;

import data.Race;
import mdtools.MDApplication;
import view.MainFrame;

/**
 *
 * @author student
 */
public class Main {

    private static ThreadDown td;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MDApplication.setLookAndFeel();
        
        MainFrame mf = new MainFrame();
        RaceAction raceAction = new RaceAction();

        raceAction.createRace();
//        Tetris race = RaceAction.getTetris();

        mf.setLocationRelativeTo(null);
        mf.setExtendedState(MainFrame.MAXIMIZED_BOTH);

//        mf.setTable(race.getTable());
        mf.setRaceAction(raceAction);

        mf.setVisible(true);

        raceAction.setComponent(mf);

//        td = new ThreadDown();
//        td.setComponent(mf);
//        td.setTetris(race);

        raceAction.setThreadDown(td);
        
        SidesListener sl = new SidesListener();
//        sl.setThreadDown(td);
        
        raceAction.setSidesListener(sl);
        
        mf.addKeyListener(sl);

//        td.start();

    }

}
