package ast;

import entities.Coordinate;
import visitor.GifComicVisitor;

public class AddImage extends PanelStep {
    String name;
    Coordinate position;

    public AddImage(String imageName, String position) {
        this.name = imageName;
        this.position = new Coordinate(position);
    }

    public String getName() {
        return name;
    }

    public Coordinate getPosition() {
        return position;
    }

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context,this);
    }
}
