package data;

/**
 *
 * @author student
 */
public class Vehicle {

    private boolean[][] table;

    public boolean[][] getTable() {
        return table;
    }

    public void setTable(boolean[][] table) {
        this.table = table;
    }

    public Vehicle() {
        makeVehicle();
    }

    /*
    Tworzenie pojazdu
    Creating a vehicle
    */
    
    private void makeVehicle() {
        table = new boolean[4][3];
        table[0][0] = false;
        table[0][1] = true;
        table[0][2] = false;
        table[1][0] = true;
        table[1][1] = true;
        table[1][2] = true;
        table[2][0] = false;
        table[2][1] = true;
        table[2][2] = false;
        table[3][0] = true;
        table[3][1] = false;
        table[3][2] = true;
    }

    /*
    Rotate a vehicle (base method)
    */
    
    public boolean[][] getRotated() {
        boolean[][] tabt = new boolean[table[0].length][table.length];

        for (int i = 0; i < tabt.length; i++) {
            for (int j = 0; j < tabt[0].length; j++) {
                tabt[i][j] = table[j][i];
            }
        }
        boolean b;
        for (int j = 0; j < tabt[0].length / 2; j++) {
            for (int i = 0; i < tabt.length; i++) {
                b = tabt[i][tabt[0].length - j - 1];
                tabt[i][tabt[0].length - j - 1] = tabt[i][j];
                tabt[i][j] = b;
            }
        }
        return tabt;
    }
  
    /*
    Rotate vehicle (2 tab version)
    */
    
    public boolean[][] getRotatedFromClasses() {
        boolean[][] tabt = new boolean[table[0].length][table.length];

        for (int i = 0; i < tabt.length; i++) {
            for (int j = 0; j < tabt[0].length; j++) {
                tabt[i][j] = table[j][i];
            }
        }
        boolean[][] tab = new boolean[tabt.length][tabt[0].length];
        for (int j = 0; j < tabt[0].length; j++) {
            for (int i = 0; i < tabt.length; i++) {
                tab[i][tab[0].length - j - 1] = tabt[i][j];
            }
        }
        return tab;
    }

    /*
    Rotate a vehicle
    */
    
    public void rotate() {
        table = getRotated();
    }
}
