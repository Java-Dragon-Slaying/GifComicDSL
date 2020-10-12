package resources;

import entities.Panel;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class Render {

    public static BufferedImage frame(Panel panel){
        return panel.background;
    }

    public static void animateAndSave(ArrayList<BufferedImage> frames, String filePath) {

        try {
            ImageOutputStream output = new FileImageOutputStream(new File(filePath));
            GifSequenceWriter writer = new GifSequenceWriter(output, frames.get(0).getType(), 500, true);

            for(BufferedImage img: frames) {
                writer.writeToSequence(img);
            }

            writer.close();
            output.close();

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage resizeBackground(BufferedImage img, int x, int y){
        Image tmp = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        resized.getGraphics().drawImage(tmp, 0, 0, null);
        return resized;
    }




}
