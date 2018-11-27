package it.sevenbits.code.lexer.token;

/**
 * Class Token.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class Token implements IToken {
    private String name;
    private String lexeme;

    /**
     * Constructor.
     *
     * @param name   - token name
     * @param lexeme - token lexeme
     */
    public Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }

    /**
     * Returns token name.
     *
     * @return token name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns a lexeme that the token contains.
     *
     * @return lexeme
     */
    @Override
    public String getLexeme() {
        return lexeme;
    }
}
