package entities;

import visitor.Acceptor;
import visitor.GifComicVisitor;

public class Coordinate extends Acceptor {
    int x;
    int y;

    public Coordinate(String coordinate) {
        String[] coordinates = coordinate.split("[\\(,\\)]");
        this.x = Integer.parseInt(coordinates[1]);
        this.y = Integer.parseInt(coordinates[2]);
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context,this);
    }
}
