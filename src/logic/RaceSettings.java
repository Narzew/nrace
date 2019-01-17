package logic;

/**
 * Klasa zawierająca zmienne statyczne, które określają parametry gry.
 *
 * @author student
 */
public class RaceSettings {
    /**
     * Ilość wierszy na planszy.
     */
    public static int rowCount = 25 + 4;
    /**
     * Ilość kolumn na planszy.
     */
    public static int colCount = 15;
    /**
     * Ilość zajętych losowo wierszy.
     */
    public static int randCount = 0;
    /**
     * Wielkość pola planszy.
     */
    public static int fildSize = 23;
    /**
     * Szybkość opuszczania klocków.
     */
    public static int interval = 500;
    /*
    Minmalna prędkość
    */
    public static int min_interval = 500;
    /**
     * Aktualny wynik gry.
     */
    public static int score = 0;
    public static int temp_score = 0;
    /**
     * Łuk do rysowania tetrisa.
     */
    public static int arc = 5;
}
