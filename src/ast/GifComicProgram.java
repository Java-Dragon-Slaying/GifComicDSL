package ast;

import visitor.Acceptor;
import visitor.GifComicVisitor;

import java.util.ArrayList;

public class GifComicProgram extends Acceptor {
    private String name;
    private ArrayList<Statement> statements;

    public GifComicProgram(String name, ArrayList<Statement> statements) {
        this.name = name;
        this.statements = statements;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Statement> getStatements() {
        return this.statements;
    }

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context, this);
    }
}
