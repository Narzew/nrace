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

}
