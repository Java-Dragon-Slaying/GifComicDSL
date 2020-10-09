package ast;

public class CreateImage extends Statement {
    String source;
    String name;

    public CreateImage(String source, String name) {
        this.source = source;
        this.name = name;
    }
}
