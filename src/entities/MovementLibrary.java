package entities;

import ast.MoveImage;
import resources.Render;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MovementLibrary {
    private final HashSet<String> movements;

    public MovementLibrary() {
        this.movements = new HashSet<String>();
        movements.add("move");
        movements.add("jump");
    }

    public String getMovementsRegex() {
        String regex = "";
        for (String m : movements) {
            regex = regex + "|" + m;
        }
        regex = regex.substring(1);
        regex = "(" + regex + ")";
        return regex;
    }

    public void generateMovement(Panel panel, ArrayList<MoveImage> moves, HashMap<String, BufferedImage> imageMap) {
        // preserve starting positions of all images in panel
        HashMap<String, Coordinate> startCoords = new HashMap<>(panel.getImageLayers());

        // gif is being rendered @ 20 frames per second, so all movements will be scaled to 1 second
        int frames = 20;
        for (int i = 1; i <= frames; i++) {
            for (MoveImage move : moves) {
                if (move.getMovement().equals("move")) {
                    move(panel, startCoords, frames, i, move);
                } else if (move.getMovement().equals("jump")) {
                    jump(panel, startCoords, frames, i, move);
                }
            }
            panel.addFrame(Render.frame(panel, imageMap));
        }
    }

    private void move(Panel panel, HashMap<String, Coordinate> startCoords, int frames, int i, MoveImage move) {
        int startX = startCoords.get(move.getName()).getX();
        int startY = startCoords.get(move.getName()).getY();
        int incX = (move.getPosition().getX() - startX) / frames;
        int incY = (move.getPosition().getY() - startY) / frames;
        int nextX = startX + incX * i;
        int nextY = startY + incY * i;
        panel.moveImage(move.getName(), new Coordinate(nextX, nextY));
    }

    private void jump(Panel panel, HashMap<String, Coordinate> startCoords, int frames, int i, MoveImage move) {
        int startX = startCoords.get(move.getName()).getX();
        int startY = startCoords.get(move.getName()).getY();
        int incX = (move.getPosition().getX() - startX) / frames;
        int nextX = startX + incX * i;
        int incY = (move.getPosition().getY() - startY) / frames;

        int maxJump = Math.abs(move.getPosition().getX() - startX) / 2;
        double currentJump = maxJump * Math.sin(i * Math.PI / 20);

        int nextY = startY - (int) currentJump + incY * i;
        panel.moveImage(move.getName(), new Coordinate(nextX, nextY));
    }
}
