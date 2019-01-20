package it.sevenbits.code.lexer.cmd.append;

import it.sevenbits.code.lexer.cmd.ICommand;
import it.sevenbits.code.lexer.token.TokenBuilder;

/**
 * Class Append.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class Append implements ICommand {
    private char c;
    private TokenBuilder tokenBuilder;

    /**
     * Constructor.
     *
     * @param tokenBuilder - TokenBuilder to use.
     * @param c            - char to append.
     */
    Append(final TokenBuilder tokenBuilder, final char c) {
        this.c = c;
        this.tokenBuilder = tokenBuilder;
    }

    /**
     * Adds character to tokenBuilder.
     */
    @Override
    public void execute() {
        tokenBuilder.addToLexeme(c);
    }
}
