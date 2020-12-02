package resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class ImageLibrary {
    private final HashMap<String, String> images;

    public ImageLibrary() {
        this.images = new HashMap<>();
        images.put("microphone", "./src/resources/images_lib/1F3A4.png");
        images.put("canada", "./src/resources/images_lib/1F1E8-1F1E6.png");
        images.put("movie_camera", "./src/resources/images_lib/1F3A5.png");
        images.put("bullseye", "./src/resources/images_lib/1F3AF.png");
        images.put("eight_ball", "./src/resources/images_lib/1F3B1.png");
        images.put("die", "./src/resources/images_lib/1F3B2.png");
        images.put("music_notes_1", "./src/resources/images_lib/1F3B5.png");
        images.put("music_notes_2", "./src/resources/images_lib/1F3B6.png");
        images.put("basketball", "./src/resources/images_lib/1F3C0.png");
        images.put("snowboarder", "./src/resources/images_lib/1F3C2.png");
        images.put("runner", "./src/resources/images_lib/1F3C3.png");
        images.put("surfer", "./src/resources/images_lib/1F3C4.png");
        images.put("trophy", "./src/resources/images_lib/1F3C6.png");
        images.put("horse_rider", "./src/resources/images_lib/1F3C7.png");
        images.put("football", "./src/resources/images_lib/1F3C8.png");
        images.put("mountain", "./src/resources/images_lib/1F3D4.png");
        images.put("sky_blue_background", "./src/resources/images_lib/1F3F3-FE0F-200D-1F7E6.png");
        images.put("champagne", "./src/resources/images_lib/1F37E.png");
        images.put("shhh", "./src/resources/images_lib/1F92B.png");
        images.put("angry", "./src/resources/images_lib/1F92C.png");
        images.put("cover_mouth", "./src/resources/images_lib/1F92D.png");
        images.put("vomit", "./src/resources/images_lib/1F92E.png");
    }

    public boolean hasImage(String img) {
        return images.containsKey(img);
    }

    public BufferedImage getImage(String img_name) {
        BufferedImage img;
        if (hasImage(img_name)) {
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
