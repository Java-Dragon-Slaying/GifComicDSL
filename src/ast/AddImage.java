package ast;

import entities.Coordinate;

public class AddImage extends PanelStep {
    String name;
    Coordinate position;

    public AddImage(String imageName, String position) {
        this.name = imageName;
        this.position = new Coordinate(position);
    }
}
