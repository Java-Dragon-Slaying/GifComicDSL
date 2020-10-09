package ast;

import visitor.GifComicVisitor;

public class RemoveImage extends PanelStep {
    String name;

    public RemoveImage(String imageName) {
        this.name = imageName;
    }

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context,this);
    }
}
