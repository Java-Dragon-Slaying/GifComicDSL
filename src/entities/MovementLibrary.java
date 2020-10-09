package entities;

import java.util.HashMap;

public class MovementLibrary {
    private final HashMap<String, String> movements; // right side links to movement code for rendering (update type)

    public MovementLibrary() {
        this.movements = new HashMap<>();

        // need something in map to be able to run parser
        movements.put("TEST", "test");
        movements.put("TEST2", "test2");

        // add actual movements here
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
