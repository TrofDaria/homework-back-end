package it.sevenbits.code.lexer;

import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.lexer.token.Token;
import it.sevenbits.code.reader.IReader;
import it.sevenbits.code.reader.ReaderException;


/**
 * Class Lexer performs lexical parsing.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class Lexer implements ILexer {
    private IReader reader;
    private StringBuilder currentLexeme;
    private boolean wordInProcess;
    private StringBuilder readyLexeme;

    /**
     * Constructor.
     *
     * @param reader - determines the reader from which lexer will be taking chars to process
     **/
    public Lexer(final IReader reader) {
        this.reader = reader;
        currentLexeme = new StringBuilder();
        readyLexeme = new StringBuilder();
        wordInProcess = false;
    }

    /**
     * Reads token and returns it.
     *
     * @throws ReaderException - throws when reading exception occurs
     */
    @Override
    public IToken readToken() throws ReaderException {
        if (readyLexeme.length() != 0) {
            currentLexeme = readyLexeme;
            readyLexeme = new StringBuilder();
            return newToken();
        }
        while (reader.hasNext()) {
            char c = reader.read();
            if (c == '{' || c == '}' || c == ';' || c == ' ') {
                if (wordInProcess) {
                    if (c == ' ') {
                        wordInProcess = false;
                        return newToken();
                    } else {
                        wordInProcess = false;
                        readyLexeme.append(c);
                        return newToken();
                    }
                } else {
                    if (c != ' ') {
                        currentLexeme.append(c);
                        return newToken();
                    }
                }
            } else {
                if (c != '\n') {
                    wordInProcess = true;
                    currentLexeme.append(c);
                }
            }
        }
        return newToken();
    }

    /**
     * Determines whether there are more token exists.
     */
    @Override
    public boolean hasMoreTokens() {
        if (readyLexeme.length() != 0) {
            return true;
        }
        return reader.hasNext();
    }

    /**
     * Creates token.
     */
    private IToken newToken() {
        String lexeme = currentLexeme.toString();
        currentLexeme = new StringBuilder();
        switch (lexeme) {
            case "{":
                return new Token("OPENING_PARENTHESIS", lexeme);
            case "}":
                return new Token("CLOSING_PARENTHESIS", lexeme);
            case ";":
                return new Token("END_OF_LINE", lexeme);
            case "":
                return new Token("NONE", lexeme);
            default:
                return new Token("WORD", lexeme);
        }
    }
}
