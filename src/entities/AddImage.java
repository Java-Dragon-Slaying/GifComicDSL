package entities;

public class AddImage extends PanelStep {
    Coordinate position;

    public AddImage(String imageName, Coordinate position) {
        super(imageName);
        this.position = position;
    }
}
