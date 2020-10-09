package ast;

import visitor.GifComicVisitor;

public class CreateImage extends Statement {
    String source;
    String name;

    public CreateImage(String source, String name) {
        this.source = source;
        this.name = name;
    }

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context,this);
    }
}
