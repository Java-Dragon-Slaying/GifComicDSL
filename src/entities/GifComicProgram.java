package entities;

import java.util.HashMap;
import java.util.List;

public class GifComicProgram {
    public static String name;
    HashMap<String, Image> imageMap;
    List<Panel> panelList;

    public GifComicProgram(String name) {
        this.name = name;
    }
}
