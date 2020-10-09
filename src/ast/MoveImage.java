package ast;

import entities.Coordinate;
import visitor.GifComicVisitor;

public class MoveImage extends PanelStep {
    String movement;
    String name;
    Coordinate position;

    public MoveImage(String movement, String imageName, String position) {
        this.movement = movement;
        this.name = imageName;
        this.position = new Coordinate(position);
    }

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context,this);
    }
}
