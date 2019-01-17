/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdtools;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class MDApplication {
    
    /**
     * Metoda ustawiająca LookAndFeel aplikacji na układ Nimbus.
     */
    public static void setLookAndFeel(){
        setLookAndFeel("Nimbus");
    }
    
    /**
     * Metoda ustawiająca LookAndFeel aplikacji na układ określony przez parametr.
     * 
     * @param name Nazwa układu Look And Feel.
     */
    public static void setLookAndFeel(String name){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (name.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            //
        }
    }
    
    public static void sleep(int milsec){
        try {
            Thread.sleep(milsec);
        } catch (InterruptedException ex) {
            Logger.getLogger(MDApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
