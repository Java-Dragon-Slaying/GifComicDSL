package ast;

import visitor.GifComicVisitor;

public abstract class PanelStep extends Statement {

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context, this);
    }

}