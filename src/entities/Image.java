package entities;

import visitor.Acceptor;
import visitor.GifComicVisitor;

public class Image extends Acceptor {
    String name;
    Coordinate position;

    public Image(String name, Coordinate position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context,this);
    }
}
