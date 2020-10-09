package ast;

import entities.Coordinate;

public class MoveImage extends PanelStep {
    String movement;
    String name;
    Coordinate position;

    public MoveImage(String movement, String imageName, String position) {
        this.movement = movement;
        this.name = imageName;
        this.position = new Coordinate(position);
    }
}
