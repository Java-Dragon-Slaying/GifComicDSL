package ast;

import entities.Image;
import visitor.Acceptor;
import visitor.GifComicVisitor;

import java.util.ArrayList;
import java.util.HashMap;

public class GifComicProgram extends Acceptor {
    private String name;
    private ArrayList<Statement> statements;
    private HashMap<String, Image> imageMap; // maybe can get rid of image and reference a ImageBuffer directly?
                                     // using strings for image reference will require unique image names

    public GifComicProgram(String name, ArrayList<Statement> statements) {
        this.name = name;
        this.statements = statements;
        this.imageMap = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Statement> getStatements() {
        return this.statements;
    }

    public HashMap<String, Image> getImageMap() {
        return this.imageMap;
    }

    @Override
    public <C, T> T accept(C context, GifComicVisitor<C, T> v) {
        return v.visit(context,this);
    }
}
