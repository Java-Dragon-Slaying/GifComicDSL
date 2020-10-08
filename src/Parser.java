import entities.GifComicProgram;

public class Parser {
    private final Tokenizer tokenizer;
    private final String NAME = "[A-Za-z]+";
    private final String NUM = "[0-9]+";

    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

//    PROGRAM ::= “comic” NAME ITEM+
    public GifComicProgram parseProgram() {
        return new GifComicProgram();
    }

//    ITEM ::= (“use” IMAGE | "create" PANEL) (";")?
//    IMAGE ::= “image” SOURCE “as” NAME
//    SOURCE ::= “tall_guy” | “basketball” | <other elements of enum>
//    PANEL::= “panel” POSITION “background” NAME (TEXT)? ADD (ADD | MOVE | REMOVE)*
//    TEXT::= “text” (“fontsize” NUM)? """ (\w)+ """
//    ADD ::= “add” NAME POSITION (“AND” ADD)* (",")?
//    MOVE ::= MOVEMENT NAME POSITION (“AND” MOVE)* (",")?
//    MOVEMENT::= "move" | "jump" | "walk" | "run" | <add more movements if we have time???> // these will be pre-defined actions
//    REMOVE ::= “remove” NAME (",")?
//    POSITION::= "(" NUM "," NUM ")"
}
