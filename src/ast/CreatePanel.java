package ast;

import entities.Coordinate;
import visitor.GifComicVisitor;

import java.util.ArrayList;

public class CreatePanel extends Statement {
    Coordinate dimensions;
    String background;
    String text;
    Integer fontsize;
    ArrayList<ArrayList<PanelStep>> panelSteps;

    public CreatePanel(String dimension, String background, String text, Integer fontsize,
                       ArrayList<ArrayList<PanelStep>> panelSteps) {
        this.dimensions = new Coordinate(Coordinate.fromString(dimension)[0], Coordinate.fromString(dimension)[1]);
        this.background = background;
        this.text = text;
        this.fontsize = fontsize;
        this.panelSteps = panelSteps;
    }

    public ArrayList<ArrayList<PanelStep>> getPanelSteps() {
        return panelSteps;
    }

    public Coordinate getDimensions() {
        return dimensions;
    }

    public String getBackground() {
        return background;
    }

    public Integer getFontsize() {
        return fontsize;
    }

    public String getText() {
        return text;
    }

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context, this);
    }
}
