import entities.GifComicProgram;
import resources.Render;

public class Main {
    public static void main(String[] args) {
        System.out.println("initialized"); // replace with proper logging statements?

        // read config...

        System.out.println("args are: " + args[0] + " " + args[1]);

        String input_file = args[0]; // read file specified in args
        String output_filepath = args[1];

        // not sure how these should be called, or where to read the file into a string. Tokenizer would be responsible
        // for stripping newlines? should parser take a tokenizer as an argument?
        String input_string = "";
        Tokenizer tokenizer = new Tokenizer("input.tvar");
        Parser parser = new Parser(tokenizer);
        GifComicProgram program = parser.parseProgram();

        Render render = new Render();

        // List<Object> output = render.renderComic(myComic); // change from object when we know appropriate types

        // render.renderHtml(GifComicProgram.name, output_filepath, output);
    }
}
