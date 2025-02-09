import ast.*;
import ast.GifComicProgram;
import entities.MovementLibrary;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Parser {
    private final Tokenizer tokenizer;
    private final String NAME = "[A-Za-z]+";
    private final String VARNAME = "[A-Za-z_]+";
    private final String NUM = "[0-9]+";
    private final String COORDINATE = "\\([0-9]+,[0-9]+\\)";
    // MOVEMENT::= "move" | "jump" | "walk" | "run" | ... // these will be pre-defined actions
    private final MovementLibrary m = new MovementLibrary();
    private final String MOVEMENTS = m.getMovementsRegex();

    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    // PROGRAM ::= “comic” NAME ITEM+
    public GifComicProgram parseProgram() {
        ArrayList<Statement> statements = new ArrayList<>();
        tokenizer.getAndCheckNext("comic");
        String name = tokenizer.getAndCheckNext(VARNAME);
        while (tokenizer.moreTokens()) {
            statements.add(parseStatement());
        }
        return new GifComicProgram(name, statements);
    }

    //    ITEM ::= (“use” IMAGE | "create" PANEL) (";")? - semicolon not kept as token
    private Statement parseStatement() {
        if (tokenizer.checkToken("use")) {
            return parseCreateImage();
        } else if (tokenizer.checkToken("create")) {
            return parseCreatePanel();
        } else {
            throw new InvalidParameterException("PARSER: unknown statement starting with token " + tokenizer.getNext());
        }
    }

    // IMAGE ::= “image” SOURCE “as” NAME
    // SOURCE ::= “tall_guy” | “basketball” | <other elements in hashmap>
    private CreateImage parseCreateImage() {
        tokenizer.getNext(); // ignore "use"
        tokenizer.getAndCheckNext("image");
        String source = tokenizer.getAndCheckNext(VARNAME);
        tokenizer.getAndCheckNext("as");
        String name = tokenizer.getAndCheckNext(NAME);
        return new CreateImage(source, name);
    }

    // PANEL::= “panel” POSITION “background” NAME (TEXT)? ADD (ADD | MOVE | REMOVE)*
    private CreatePanel parseCreatePanel() {
        tokenizer.getNext(); // ignore "create"
        tokenizer.getAndCheckNext("panel");
        String dimensions = tokenizer.getAndCheckNext(COORDINATE);
        tokenizer.getAndCheckNext("background");
        String background = tokenizer.getAndCheckNext(NAME);
        if (tokenizer.checkToken("text")) {
            return parseCreateTextPanel(dimensions, background);
        }
        ArrayList<ArrayList<PanelStep>> panelSteps = new ArrayList<>();
        while (tokenizer.checkToken("add") || tokenizer.checkToken(MOVEMENTS) || tokenizer.checkToken("remove")) {
            if (tokenizer.checkToken("add")) {
                panelSteps.add(parseAddImages());
            } else if (tokenizer.checkToken(MOVEMENTS)) {
                panelSteps.add(parseMoveImages());
            } else {
                panelSteps.add(parseRemoveImage());
            }
        }
        // text, fontsize are default values (weren't given by user)
        return new CreatePanel(dimensions, background, "", 0, panelSteps);
    }

    // PANEL::= “panel” POSITION “background” NAME (TEXT)? ADD (ADD | MOVE | REMOVE)*
    // TEXT::= “text” (“fontsize” NUM)? """ (\w)+ """
    private CreatePanel parseCreateTextPanel(String position, String background) {
        tokenizer.getNext(); // ignore "text"
        int fontsize = 0;
        if (tokenizer.checkToken("fontsize")) {
            tokenizer.getNext();
            fontsize = Integer.parseInt(tokenizer.getAndCheckNext(NUM));
        }
        String text = tokenizer.getAndCheckNext("^[a-zA-Z0-9_!? ]*");
        ArrayList<ArrayList<PanelStep>> panelSteps = new ArrayList<>();
        while (tokenizer.checkToken("add") || tokenizer.checkToken(MOVEMENTS) || tokenizer.checkToken("remove")) {
            if (tokenizer.checkToken("add")) {
                panelSteps.add(parseAddImages());
            } else if (tokenizer.checkToken(MOVEMENTS)) {
                panelSteps.add(parseMoveImages());
            } else {
                panelSteps.add(parseRemoveImage());
            }
        }
        return new CreatePanel(position, background, text, fontsize, panelSteps);
    }

    // ADD ::= “add” NAME POSITION (“AND” ADD)* (",")?
    private ArrayList<PanelStep> parseAddImages() {
        ArrayList<PanelStep> adds = new ArrayList<>();
        adds.add(parseAddSingleImage());
        while (tokenizer.checkToken("AND")) {
            tokenizer.getNext(); // ignore "AND"
            adds.add(parseAddSingleImage());
        }
        return adds;
    }

    private AddImage parseAddSingleImage() {
        tokenizer.getNext(); // ignore "add"
        String name = tokenizer.getAndCheckNext(NAME);
        String position = tokenizer.getAndCheckNext(COORDINATE);
        return new AddImage(name, position);
    }

    // MOVE ::= MOVEMENT NAME POSITION (“AND” MOVE)* (",")?
    private ArrayList<PanelStep> parseMoveImages() {
        ArrayList<PanelStep> moves = new ArrayList<>();
        moves.add(parseMoveSingleImage());
        while (tokenizer.checkToken("AND")) {
            tokenizer.getNext(); // ignore "AND"
            moves.add(parseMoveSingleImage());
        }
        return moves;
    }

    private MoveImage parseMoveSingleImage() {
        String movement = tokenizer.getAndCheckNext(MOVEMENTS);
        String name = tokenizer.getAndCheckNext(NAME);
        String position = tokenizer.getAndCheckNext(COORDINATE);
        return new MoveImage(movement, name, position);
    }

    // REMOVE ::= “remove” NAME (",")?
    private ArrayList<PanelStep> parseRemoveImage() {
        ArrayList<PanelStep> remove = new ArrayList<>();
        tokenizer.getNext(); // ignore "remove"
        String name = tokenizer.getAndCheckNext(NAME);
        remove.add(new RemoveImage(name));
        return remove;
    }
}
