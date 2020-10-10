package entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageLibrary {
    private final HashMap<String, String> images;

    public ImageLibrary() {
        this.images = new HashMap<>();
        // add images that we're keeping here
        // add checks for making sure the image source is in the map (in renderer when creating image objects)

        images.put("microphone", "images_lib/1F3A42.png");

    }

    public boolean hasImage(String img){
        return images.containsKey(img);
    }

    public boolean validFilePath(String filepath){
        File
    }

    public BufferedImage getImage(String filepath) throws IOException {
        File file = new File(filepath);
        BufferedImage img;
        img = ImageIO.read(file);
        return img;
    }

}
