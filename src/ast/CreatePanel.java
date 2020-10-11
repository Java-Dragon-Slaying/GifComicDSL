package ast;

import entities.Coordinate;
import visitor.GifComicVisitor;

import java.util.ArrayList;

public class CreatePanel extends Statement {
    Coordinate coordinate;
    String background;
    String text;
    Integer fontsize;
    ArrayList<ArrayList<PanelStep>> panelSteps;

    public CreatePanel(String coordinate, String background, String text, Integer fontsize,
                       ArrayList<ArrayList<PanelStep>>  panelSteps) {
        this.coordinate = new Coordinate(coordinate);
        this.background = background;
        this.text = text;
        this.fontsize = fontsize;
        this.panelSteps = panelSteps;
    }

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context,this);
    }
}
