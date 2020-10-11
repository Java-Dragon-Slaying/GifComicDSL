package visitor;

public abstract class Acceptor {
        abstract public <C, T> T accept(C context, GifComicVisitor<C, T> v);
    }
