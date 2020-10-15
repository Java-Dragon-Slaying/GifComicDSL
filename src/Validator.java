import ast.*;
import entities.Coordinate;
import visitor.GifComicVisitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class Validator implements GifComicVisitor <Set<String>, String> {
    Integer panelX = 0;
    Integer panelY = 0;
    Integer maxPanelSize = 500;
    Integer maxFontsSize = maxPanelSize / 4;
    Set<String> panelContext = new HashSet<>();



    @Override
    public String visit(Set<String> context, GifComicProgram gfc) {
        String validationError = "";
        for(Statement s: gfc.getStatements()) {
            validationError += s.accept(context, this);
        }
        return validationError;
    }

    @Override
    public String visit(Set<String> context, CreateImage createImage) {
        context.add(createImage.getName());
        return "";
    }

    @Override
    public String visit(Set<String> context, CreatePanel createPanel) {
        String validationError = "";
        panelX = createPanel.getCoordinate().getX();
        panelY = createPanel.getCoordinate().getY();
        panelContext = new HashSet<>();

        if(!createPanel.getText().equals("") && createPanel.getFontsize() > maxFontsSize){
            return "font size too big \n";
        }
        //Check panel size
        if(outOfBounds(panelX, panelY, maxPanelSize, maxPanelSize)){
            return "panel size out of bounds\n";
        }
        //Check if background img is declared before use
        if(!context.contains(createPanel.getBackground())){
            return "background " + createPanel.getBackground() + " is not declared \n";
        }
        //Visit each panelSteps
        final AtomicReference<Set<String>> notifier = new AtomicReference<>();

        for(ArrayList<PanelStep> stepList : createPanel.getPanelSteps()) {
            for(PanelStep s: stepList){
                validationError += s.accept(context, this);
            }
        }
        return validationError;
    }

    @Override
    public String visit(Set<String> context, PanelStep ps) {
        return ps.accept(context, this);
    }

    @Override
    public String visit(Set<String> context, AddImage addImage) {
        String imgName = addImage.getName();
        if(!context.contains(imgName)){
            return "try to add image " + imgName + " before being created\n";
        }
        Coordinate imgXY = addImage.getPosition();
        //Check image out of panel bounds
        if(outOfBounds(imgXY.getX(), imgXY.getY(), panelX, panelY)){
            return "trying to add image out of bounds\n";
        }
        panelContext.add(imgName);
        return "";
    }

    @Override
    public String visit(Set<String> context, MoveImage m) {
        String imgName = m.getName();
        if(!panelContext.contains(imgName)){
            return "trying to move image " + imgName + ", which is not added to panel\n";
        }
        Coordinate imgXY = m.getPosition();
        //Check image out of panel bounds (may allow?)
        if(outOfBounds(imgXY.getX(), imgXY.getY(), panelX, panelY)){
            return "trying to move image out of bounds\n";
        }
        return "";
    }

    @Override
    public String visit(Set<String> context, RemoveImage r) {
        String imgName = r.getName();
        if(!panelContext.contains(imgName)){
            return "trying to remove image " + imgName + ", which is not added to panel\n";
        }
        panelContext.remove(imgName);
        return "";
    }

    private Boolean outOfBounds(Integer posX, Integer posY, Integer limitX, Integer limitY){
        return (posX > limitX || posY > limitY);
    }

}
