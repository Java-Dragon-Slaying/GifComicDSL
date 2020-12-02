import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Tokenizer {
    private String inputProgram;
    private String[] tokens;
    private int currentToken = 0;

    public Tokenizer(String filename) {
        try {
            inputProgram = Files.readString(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("File not found: " + filename);
            System.exit(0);
        }
        tokenize();
    }

    private void tokenize() {
        String tokenizedProgram = inputProgram.replace("\n", "");
        tokens = tokenizedProgram.split("\\s+(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].replaceAll("\"", "");
            tokens[i] = tokens[i].replaceAll("\\;", "");
            if (tokens[i].endsWith(",")) {
                tokens[i] = tokens[i].substring(0, tokens[i].length() - 1);
            }
        }
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].trim();
        }
        System.out.println("Tokens: " + Arrays.asList(tokens));
    }

    private String checkNext() {
        String token = "";
        if (currentToken < tokens.length) {
            token = tokens[currentToken];
        } else
            token = "NO_MORE_TOKENS";
        return token;
    }

    public String getNext() {
        String token = "";
        if (currentToken < tokens.length) {
            token = tokens[currentToken];
            currentToken++;
        } else
            token = "NULLTOKEN";
        return token;
    }

    public boolean checkToken(String regex) {
        String n = checkNext();
        System.out.println("comparing: |" + n + "|  to  |" + regex + "|");
        return (n.matches(regex));
    }

    public String getAndCheckNext(String regex) {
        String n = getNext();
        if (!n.matches(regex)) {
            throw new RuntimeException("TOKENIZER: Expected something matching: " + regex + " but got: " + n);
        }
        System.out.println("matched: " + n + "  to  " + regex);
        return n;
    }

    public boolean moreTokens() {
        return currentToken < tokens.length;
    }
}
