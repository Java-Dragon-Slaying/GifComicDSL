package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class GifComicProgram {
//    public static String name;
    HashMap<String, Image> imageMap; // maybe can get rid of image and reference a ImageBuffer directly?
                                     // using strings for image reference will require unique image names
    ArrayList<PanelStep> panelStepList;

    public GifComicProgram(ArrayList<PanelStep> panelStepList) {
        this.panelStepList = panelStepList;
    }
}
