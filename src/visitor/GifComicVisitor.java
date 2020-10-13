package visitor;

import ast.*;

import java.util.ArrayList;

public interface GifComicVisitor<C,T> {
    T visit(C context, AddImage addImage);
    T visit(C context, GifComicProgram gfc);
    T visit(C context, MoveImage m);
    T visit(C context, PanelStep ps);
    T visit(C context, RemoveImage r);
    T visit(C context, CreateImage createImage);
    T visit(C context, CreatePanel createPanel);
}
