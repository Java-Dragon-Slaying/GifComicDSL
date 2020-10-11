import ast.GifComicProgram;
import resources.Render;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("initialized"); // replace with proper logging statements?

        Tokenizer tokenizer = new Tokenizer("input.tvar");
        Parser parser = new Parser(tokenizer);


        GifComicProgram program = parser.parseProgram();
        Validator validator = new Validator();
        String validationError = program.accept(new HashSet<>(), validator);
        if(!validationError.equals("")){
            throw new RuntimeException("Validation failed, reasons: \n" + validationError);
        }

        Render renderer = new Render(program.getName());
        program.accept(null, renderer);
    }
}
