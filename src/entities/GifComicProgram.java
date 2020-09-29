package entities;

import java.util.HashMap;
import java.util.List;

public class GifComicProgram {
    public static String name;
    HashMap<String, Image> imageMap; // maybe can get rid of image and reference a ImageBuffer directly?
                                     // using strings for image reference will require unique image names
    List<Panel> panelList;

    public GifComicProgram(String name) {
        this.name = name;
    }
}
