package data;

import java.util.ArrayList;
import logic.RaceSettings;
import mdtools.MDApplication;

/**
 *
 * @author Michał Dolecki <michal.dolecki@kul.pl>
 */
public class Race {

    private boolean table[][];

    public Race(int rows, int cols) {
        table = new boolean[rows][cols];
    }

    public void random(int height) {
        if (height < table.length) {
            for (int i = table.length - height; i < table.length; i++) {
                for (int j = 0; j < table[0].length; j++) {
                    if (Math.random() < 0.5) {
                        table[i][j] = true;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Liczba losowanych wierszy jest większa od wielkości planszy!");
        }
    }

    public boolean getElement(int row, int col) {
        return table[row][col];
    }

    public boolean[][] getTable() {
        return table;
    }

    public void draw(int row, int col, boolean[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (tab[i][j]) {
                    table[row + i][col + j] = tab[i][j];
                }
            }
        }
    }

    public boolean isPlace(int row, int col, boolean[][] tab) {
        if (row < 0 || row + tab.length > table.length) {
            return false;
        }
        if (col < 0 || col + tab[0].length > table[0].length) {
            return false;
        }
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (table[row + i][col + j] && tab[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear(int row, int col, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (table[row + i][col + j]) {
                    table[row + i][col + j] = false;
                }
            }
        }
    }

    public void clear(int row, int col, boolean[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (tab[i][j] && table[row + i][col + j]) {
                    table[row + i][col + j] = false;
                }
            }
        }
    }

    public void clear() {
        clear(0, 0, table.length, table[0].length);
    }

    private boolean isFull(int nr) {
        if (nr < 0 || nr >= table.length) {
            throw new ArrayIndexOutOfBoundsException("Linia nie istnieje!");
        }
        for (int i = 0; i < table[nr].length; i++) {
            if (!table[nr][i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty(int nr) {
        if (nr < 0 || nr >= table.length) {
            throw new ArrayIndexOutOfBoundsException("Linia nie istnieje!");
        }
        for (int i = 0; i < table[nr].length; i++) {
            if (table[nr][i]) {
                return false;
            }
        }
        return true;
    }

    public Integer[] selectLines() {
        ArrayList<Integer> lines = new ArrayList<>();
        int i = table.length - 1;
        while (!isEmpty(i)) {
            if (isFull(i)) {
                lines.add(i);
            }
            i--;
        }
        return lines.toArray(new Integer[0]);
    }

    public void deleteLine(int idx) {
        if (idx < 0 || idx >= table.length) {
            throw new ArrayIndexOutOfBoundsException("Linia nie istnieje!");
        }
        for (int i = 0; i < table[idx].length; i++) {
            table[idx][i] = false;
        }
    }

    public void moveDown(int idx) {
        for (int i = idx; i > 0; i--) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = table[i - 1][j];
            }
        }
    }

    public void delete() {
        Integer[] toDelete = selectLines();

        if (toDelete.length > 0) {
            RaceSettings.score += toDelete.length * toDelete.length * 10;
            //nie może być < 0. Trzeba lepiej wyskalować zmianę czasu.
            RaceSettings.interval -= toDelete.length * 10;
            if (RaceSettings.interval<0) {
                RaceSettings.interval = 10;
            }
            for (int i = toDelete.length - 1; i >= 0; i--) {
                deleteLine(toDelete[i]);
//                MDApplication.sleep(50);
                moveDown(toDelete[i]);
            }
        }
    }
}
