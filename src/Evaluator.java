import ast.*;
import entities.Coordinate;
import entities.MovementLibrary;
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

public class Evaluator implements GifComicVisitor <Panel, Panel> {

    String outFile;
    PrintWriter html;
    private HashMap<String, BufferedImage> imageMap;
    private ImageLibrary imageLibrary;
    private MovementLibrary movementLibrary;
    int panelNum;

    public Evaluator(String outFile) throws FileNotFoundException, UnsupportedEncodingException {
        this.outFile = outFile;
        this.html = new PrintWriter("output/"+outFile+".html", "UTF-8");
        this.imageMap = new HashMap<>();
        this.imageLibrary = new ImageLibrary();
        this.movementLibrary = new MovementLibrary();
        this.panelNum= 0;
    }

    @Override
    public Panel visit(Panel panel, GifComicProgram gfc) {
        for(Statement s: gfc.getStatements()){
            s.accept(panel, this);
        }
        html.close();
        return null;
    }

    @Override
    public Panel visit(Panel context, CreateImage createImage) {
        BufferedImage img;
        img = imageLibrary.getImage(createImage.getSource());
        imageMap.put(createImage.getName(), img);
        return null;
    }
    @Override
    public Panel visit(Panel context, CreatePanel createPanel) {
        BufferedImage background;
        Panel panel;
        Coordinate dim = createPanel.getDimensions();

        // size background image to dim
        background = Render.resizeBackground(imageMap.get(createPanel.getBackground()), dim.getX(), dim.getY());
        panel = new Panel(background, createPanel.getText(), createPanel.getFontsize());

        for(ArrayList<PanelStep> steps: createPanel.getPanelSteps()){
            PanelStep first = steps.get(0); // relies on our grammar/parser enforcing that PanelSteps in array must be same type
            panel.setCurrentEval(steps);
            first.accept(panel, this);
            panel.setCurrentEval(null);
        }
        String gifFile = outFile + panelNum + ".gif";
        Render.animateAndSave(panel.getFrames(), "output/"+gifFile);
        html.println("<div><img src=\""+gifFile+"\" alt=\"" + outFile + " panel " + panelNum + "\" style=\"margin-bottom:3cm;\"></div>");
        panelNum++;
        return null;
    }

    @Override
    public Panel visit(Panel panel, AddImage addImage) {
        for(PanelStep ps: panel.getCurrentEval()){
            AddImage add = (AddImage) ps;
            panel.addImage(add);
        }
        panel.addFrame(Render.frame(panel, imageMap));
        return null;
    }

    @Override
    public Panel visit(Panel panel, MoveImage m) {
        ArrayList<MoveImage> moves = new ArrayList<>();
        for(PanelStep ps: panel.getCurrentEval()){
            MoveImage move = (MoveImage) ps;
            moves.add(move);
        }
        movementLibrary.generateMovement(panel, moves, imageMap);
        return null;
    }

    @Override
    public Panel visit(Panel panel, PanelStep ps) {
        return null;
    }

    @Override
    public Panel visit(Panel panel, RemoveImage r) {
        for(PanelStep ps: panel.getCurrentEval()){
            RemoveImage remove = (RemoveImage) ps;
            panel.removeImage(remove);
        }
        panel.addFrame(Render.frame(panel, imageMap));
        return null;
    }

}
