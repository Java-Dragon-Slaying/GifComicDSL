package entities;

import java.util.HashMap;

public class MovementLibrary {
    private final HashMap<String, String> movements; // right side links to movement code for rendering

    public MovementLibrary() {
        this.movements = new HashMap<>();
        // add movements here
    }

    public String getMovementsRegex() {
        String regex = "";
        for (String m : movements.keySet()) {
            regex = regex + "|" + m;
        }
        regex = regex.substring(1);
        regex = "(" + regex + ")";
        return regex;
    }
}
