package resources;

import entities.Coordinate;
import entities.Panel;

import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class Render {
    public static BufferedImage frame(Panel panel, HashMap<String, BufferedImage> imageMap) {
        BufferedImage background = panel.getBackground();
        BufferedImage frame = new BufferedImage(background.getWidth(), background.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        frame.getGraphics().drawImage(background, 0, 0, null);
        for (HashMap.Entry<String, Coordinate> entry : panel.getImageLayers().entrySet()) {
            String name = entry.getKey();
            Coordinate coordinate = entry.getValue();
            BufferedImage img = imageMap.get(name);
            int x = coordinate.getX() - img.getWidth() / 2;
            int y = coordinate.getY() - img.getHeight() / 2;
            frame.getGraphics().drawImage(img, x, y, null);
        }
        if (panel.getText() != null) {
            Graphics2D typewriter = frame.createGraphics();
            typewriter.setFont(new Font("TimesNewRoman", Font.PLAIN, panel.getFontSize()));
            typewriter.setColor(Color.BLACK);
            typewriter.drawString(panel.getText(), panel.getTextPosition().getX(), panel.getTextPosition().getY());
        }
        return frame;
    }

    public static void animateAndSave(ArrayList<BufferedImage> frames, String filePath) {
        try {
            ImageOutputStream output = new FileImageOutputStream(new File(filePath));
            GifSequenceWriter writer = new GifSequenceWriter(output, frames.get(0).getType(), 50, true);
            for (BufferedImage img : frames) {
                writer.writeToSequence(img);
            }
            writer.close();
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage resizeBackground(BufferedImage img, int x, int y) {
        int px, py;
        // For an origin at img's center, find the first non-transparent/black pixel on the x axis
        for (px = 0; px < img.getWidth(); px++) {
            int rgb = img.getRGB(px, img.getHeight() / 2);
            int alpha = (rgb >> 24) & 0xFF;
            int red = (rgb >> 16) & 0xFF;
            int green = (rgb >> 8) & 0xFF;
            int blue = (rgb) & 0xFF;
            if ((alpha != 0) && (red + green + blue != 0)) {
                break;
            }
        }
        // For an origin at img's center, find the first non-transparent/black pixel on the y axis
        for (py = 0; py < img.getWidth(); py++) {
            int rgb = img.getRGB(img.getWidth() / 2, py);
            int alpha = (rgb >> 24) & 0xFF;
            int red = (rgb >> 16) & 0xFF;
            int green = (rgb >> 8) & 0xFF;
            int blue = (rgb) & 0xFF;
            if ((alpha != 0) && (red + green + blue != 0)) {
                break;
            }
        }
        // take center of the image, cropping away transparent borders
        img = img.getSubimage(px, py, img.getWidth() - 2 * px, img.getHeight() - 2 * py);
        Image tmp = img.getScaledInstance(x, y, Image.SCALE_DEFAULT);
        BufferedImage resized = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        resized.getGraphics().drawImage(tmp, 0, 0, null);
        return resized;
    }
}
