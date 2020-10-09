package visitor;

import ast.*;
import entities.*;

public interface GifComicVisitor<C,T> {
    T visit(C context, AddImage addImage);
    T visit(C context, Coordinate c);
    T visit(C context, GifComicProgram gfc);
    T visit(C context, Image i);
    T visit(C context, MoveImage m);
    T visit(C context, Panel p);
    T visit(C context, PanelStep ps);
    T visit(C context, RemoveImage r);
    T visit(C context, CreateImage createImage);
    T visit(C context, CreatePanel createPanel);
    T visit(C context, MovementLibrary movementLibrary);
}
