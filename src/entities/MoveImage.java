package entities;

public class MoveImage extends PanelStep {
    Coordinate movement;

    public MoveImage(String imageName, Coordinate movement) {
        super(imageName);
        this.movement = movement;
    }
}
