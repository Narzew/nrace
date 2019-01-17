package view;

import java.awt.Color;
import java.awt.Graphics;
import logic.RaceSettings;

/**
 *
 * @author student
 */
public class RacePanel extends javax.swing.JPanel {

    private int k, w, size, arc;
    private int marginLeft,marginTop;

    /**
     * Creates new form TetrisPanel
     */
    public RacePanel() {
        initComponents();  
        size = RaceSettings.fildSize;
        arc = RaceSettings.arc;
    }

    private void countMargins() {
        marginLeft = (this.getWidth() - table[0].length * size)/2;
        marginTop = (this.getHeight()- (table.length-4) * size)/2;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (table == null || w == 0) {
            return;
        }

        countMargins();
        
        for (int i = 4; i < w; i++) {
            for (int j = 0; j < k; j++) { 
                if (table[i][j]) {
                    g.setColor(Color.red);
                    g.fillRoundRect(j * size + marginLeft, (i - 4) * size + marginTop, size, size, arc, arc);
                    g.setColor(Color.black);
                    g.drawRoundRect(j * size + marginLeft, (i - 4) * size + marginTop, size, size, arc, arc);
                } else {
                    g.setColor(Color.white);
                    g.fillRoundRect(j * size + marginLeft, (i - 4) * size + marginTop, size, size, arc, arc);
                    g.setColor(Color.black);
                    g.drawRoundRect(j * size + marginLeft, (i - 4) * size + marginTop, size, size, arc, arc);
                }
                          
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private boolean[][] table;

    public void setTable(boolean[][] table) {
        this.table = table;
        w = table.length;
        if (w != 0) {
            k = table[0].length;
        }
    }

}
