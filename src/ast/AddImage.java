package ast;

import entities.Coordinate;

public class AddImage extends PanelStep {
    String name;
    Coordinate position;

    public AddImage(String imageName, Coordinate position) {
        this.name = imageName;
        this.position = position;
    }
}
