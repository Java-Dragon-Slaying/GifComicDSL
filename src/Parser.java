import entities.GifComicProgram;

public class Parser {

    public GifComicProgram parseGifComicProgram(String input) {

        String name = input;
        return new GifComicProgram(name);
    }
}
