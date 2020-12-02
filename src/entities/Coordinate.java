package entities;

public class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
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

    public static int[] fromString(String coord_str) {
        String[] coordinates = coord_str.split("[\\(,\\)]");
        int xi = Integer.parseInt(coordinates[1]);
        int yi = Integer.parseInt(coordinates[2]);
        return new int[]{xi, yi};
    }

}
