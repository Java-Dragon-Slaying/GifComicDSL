package resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class ImageLibrary {
    private final HashMap<String, String> images;

    public ImageLibrary() {
        this.images = new HashMap<>();
        // add images that we're keeping here
        // add checks for making sure the image source is in the map (in renderer when creating image objects)

        images.put("microphone", "./src/resources/images_lib/1F3A4.png");
        images.put("canada", "./src/resources/images_lib/1F3A4.png");

    }

    public boolean hasImage(String img){
        return images.containsKey(img);
    }

    public BufferedImage getImage(String img_name) {
        String filepath;
        BufferedImage img;
        if(hasImage(img_name)){
            try {
                img = ImageIO.read(new File(images.get(img_name)));
            } catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("invalid SOURCE argument: " + img_name + " not found in ImageLibrary");
        }
        return img;
    }

}
