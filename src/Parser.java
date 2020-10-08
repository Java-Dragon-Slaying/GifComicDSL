import ast.CreateImage;
import ast.Statement;
import entities.GifComicProgram;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Parser {
    private final Tokenizer tokenizer;
    private final String NAME = "[A-Za-z]+";
    private final String NUM = "[0-9]+";

    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    //PROGRAM ::= “comic” NAME ITEM+
    public GifComicProgram parseProgram() {
        ArrayList<Statement> statements = new ArrayList<>();
        tokenizer.getAndCheckNext("comic");
        tokenizer.getAndCheckNext(NAME);
        while(tokenizer.moreTokens()) {
            statements.add(parseStatement());
        }
        return new GifComicProgram(statements);
    }

    private Statement parseStatement() {
        if (tokenizer.checkToken("use")) {
            return parseCreateImage();
        } else if (tokenizer.checkToken("create")) {
            return parseCreatePanel();
        } else {
            throw new InvalidParameterException("PARSER: unknown statement with token " + tokenizer.getNext());
        }
    }


//    ITEM ::= (“use” IMAGE | "create" PANEL) (";")? - semicolon not kept as token

//    IMAGE ::= “image” SOURCE “as” NAME
    private CreateImage parseCreateImage() {
        tokenizer.getAndCheckNext("image");
        String source = tokenizer.getAndCheckNext(NAME);
        tokenizer.getAndCheckNext("as");
        String name = tokenizer.getAndCheckNext(NAME);
        return new CreateImage(source, name);
    }
//    SOURCE ::= “tall_guy” | “basketball” | <other elements of enum>
//    PANEL::= “panel” POSITION “background” NAME (TEXT)? ADD (ADD | MOVE | REMOVE)*
//    TEXT::= “text” (“fontsize” NUM)? """ (\w)+ """
//    ADD ::= “add” NAME POSITION (“AND” ADD)* (",")?
//    MOVE ::= MOVEMENT NAME POSITION (“AND” MOVE)* (",")?
//    MOVEMENT::= "move" | "jump" | "walk" | "run" | <add more movements if we have time???> // these will be pre-defined actions
//    REMOVE ::= “remove” NAME (",")?
//    POSITION::= "(" NUM "," NUM ")"
}
