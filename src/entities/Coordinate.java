package entities;

public class Coordinate {
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

}
