package entities;

import java.util.HashMap;

public class ImageLibrary {
    private final HashMap<String, String> images;

    public ImageLibrary() {
        this.images = new HashMap<>();
        // add images that we're keeping here
        // add checks for making sure the image source is in the map (in renderer when creating image objects)
    }

}
