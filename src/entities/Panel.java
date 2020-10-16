package entities;

import ast.AddImage;
import ast.PanelStep;
import ast.RemoveImage;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedHashMap;

// Panel maintains information about the state of a given panel

public class Panel {
    BufferedImage background;
    String text;
    Coordinate textPosition;
    int fontSize; // should go in a config
    ArrayList<PanelStep> currentEval;
    ArrayList<BufferedImage> frames;
    LinkedHashMap<String, Coordinate> imageLayers;

    // may need to store default text color here as well?


    public Panel(BufferedImage background, String text, int fontSize) {
        this.background = background;
        this.frames = new ArrayList<>();
        this.text = text;
        this.fontSize =  fontSize > 0 ? fontSize : 12;
        this.textPosition =  new Coordinate(background.getWidth()/5, background.getHeight()/5);
         // default values are near upper left for first char in string
        this.imageLayers = new LinkedHashMap<>();
    }

    public String getText() {
        return this.text;
    }

    public Coordinate getTextPosition() {
        return this.textPosition;
    }

    public Integer getFontSize() {
        return this.fontSize;
    }

    public BufferedImage getBackground() {
        return background;
    }

    public LinkedHashMap<String, Coordinate> getImageLayers(){
        return imageLayers;
    }

    public void setCurrentEval(ArrayList<PanelStep> panelsteps){
        currentEval = panelsteps;
    }

    public ArrayList<PanelStep> getCurrentEval(){return currentEval; }

    public void addFrame(BufferedImage frame){
        frames.add(frame);
    }

    public ArrayList<BufferedImage> getFrames() {
        return frames;
    }

    public void addImage(AddImage add) {
        imageLayers.put(add.getName(), add.getPosition());
    }

    public void moveImage(String name, Coordinate coordinate){
        imageLayers.put(name, coordinate);
    }

    public void removeImage(RemoveImage remove) {
        imageLayers.remove(remove.getName());
    }
}
