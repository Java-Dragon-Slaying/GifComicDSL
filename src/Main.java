import ast.GifComicProgram;
import resources.Render;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("initialized"); // replace with proper logging statements?

        Tokenizer tokenizer = new Tokenizer("input.tvar");
        Parser parser = new Parser(tokenizer);
        GifComicProgram program = parser.parseProgram();

        Render renderer = new Render(program.getName());
        String context = "";
        program.accept(context, renderer);
    }
}
