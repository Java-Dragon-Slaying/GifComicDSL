import ast.*;
import entities.Coordinate;
import entities.Panel;
import resources.ImageLibrary;
import resources.Render;
import visitor.GifComicVisitor;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class Evaluator implements GifComicVisitor {

    String outFile;
    PrintWriter html;
    private HashMap<String, BufferedImage> imageMap;
    private ImageLibrary imageLibrary;
    int panelNum;

    public Evaluator(String outFile) throws FileNotFoundException, UnsupportedEncodingException {
        this.outFile = outFile;
        this.html = new PrintWriter("output/"+outFile+".html", "UTF-8");
        this.imageMap = new HashMap<>();
        this.imageLibrary = new ImageLibrary();
        this.panelNum= 0;
    }

    @Override
    public Object visit(Object context, GifComicProgram gfc) {
        for(Statement s: gfc.getStatements()){
            s.accept(context, this);
        }
        html.close();
        return null;
    }

    @Override
    public Object visit(Object context, CreateImage createImage) {
        BufferedImage img;
        img = imageLibrary.getImage(createImage.getSource());
        imageMap.put(createImage.getName(), img);
        return null;
    }
    @Override
    public Object visit(Object context, CreatePanel createPanel) {
        BufferedImage background;
        Panel panel;
        Coordinate dim = createPanel.getDimensions();
        background = Render.resizeBackground(imageMap.get(createPanel.getBackground()), dim.getX(), dim.getY());
        panel = new Panel(background, createPanel.getPanelSteps());
        ArrayList<BufferedImage> frames = new ArrayList<>();
        for(ArrayList<PanelStep> steps: createPanel.getPanelSteps()){
            for(PanelStep s: steps){
                s.accept(panel, this);
            }
            frames.add(Render.frame(panel));
        }
        String gifFile = outFile + panelNum + ".gif";
        Render.animateAndSave(frames, "output/"+gifFile);
        html.println("<div><img src=\""+gifFile+"\" alt=\"" + outFile + " panel " + panelNum + "\"></div>");
        panelNum++;
        return null;
    }

    @Override
    public Object visit(Object context, AddImage addImage) {

        return null;
    }

    @Override
    public Object visit(Object context, MoveImage m) {
        return null;
    }

    @Override
    public Object visit(Object context, PanelStep ps) {
        return null;
    }

    @Override
    public Object visit(Object context, RemoveImage r) {
        return null;
    }

}
