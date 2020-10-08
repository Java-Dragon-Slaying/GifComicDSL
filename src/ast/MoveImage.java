package ast;

import entities.Coordinate;

public class MoveImage extends PanelStep {
    String name;
    Coordinate position;

    public MoveImage(String imageName, Coordinate position) {
        this.name = imageName;
        this.position = position;
    }
}
