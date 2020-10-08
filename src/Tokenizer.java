import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Tokenizer  {

    public static Tokenizer createSimpleTokenizer(String filename)
    {
        return new Tokenizer(filename);
    }

    private String inputProgram;
    private String[] tokens;
    private int currentToken = 0;

    private Tokenizer(String filename){
        try {
            inputProgram = Files.readString(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("Didn't find file");
            System.exit(0);
        }
        tokenize();
    }


    private void tokenize (){

        //1. Read the whole program into a single string; kill the newlines
        String tokenizedProgram = inputProgram.replace("\n", "");
        //2. Split the tokens
        tokens = tokenizedProgram.split("\\s+(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

        //3. Remove the quote and ending comma and semicolon
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].replaceAll("\"", "");
            tokens[i] = tokens[i].replaceAll("\\;", "");
            if(tokens[i].endsWith(",")){
                tokens[i] = tokens[i].substring(0, tokens[i].length()-1);
            }
        }

        //4. Trim whitespace around tokens
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].trim();
        }
        System.out.println("Tokens: " +Arrays.asList(tokens));
    }


    private String checkNext(){
        String token="";
        if (currentToken<tokens.length){
            token = tokens[currentToken];
        }
        else
            token="NO_MORE_TOKENS";
        return token;
    }

    public String getNext(){
        String token="";
        if (currentToken<tokens.length){
            token = tokens[currentToken];
            currentToken++;
        }
        else
            token="NULLTOKEN";
        return token;
    }


    public boolean checkToken(String regexp){
        String s = checkNext();
        System.out.println("comparing: |"+s+"|  to  |"+regexp+"|");
        return (s.matches(regexp));
    }


    public String getAndCheckNext(String regexp){
        String s = getNext();
        if (!s.matches(regexp)) {
            throw new RuntimeException("Unexpected next token for Parsing! Expected something matching: " + regexp + " but got: " + s);
        }
        System.out.println("matched: "+s+"  to  "+regexp);
        return s;
    }

    public boolean moreTokens(){
        return currentToken<tokens.length;
    }

}
