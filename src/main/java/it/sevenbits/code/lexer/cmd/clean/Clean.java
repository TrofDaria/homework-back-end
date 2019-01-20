package it.sevenbits.code.lexer.cmd.clean;

import it.sevenbits.code.lexer.cmd.ICommand;
import it.sevenbits.code.lexer.token.TokenBuilder;

/**
 * Class Clean.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class Clean implements ICommand {

    private char c;
    private TokenBuilder tokenBuilder;

    /**
     * Constructor.
     *
     * @param tokenBuilder - TokenBuilder to use.
     * @param c            - char to process.
     */
    Clean(final TokenBuilder tokenBuilder, final char c) {
        this.c = c;
        this.tokenBuilder = tokenBuilder;
    }

    /**
     * Cleans tokenBuilder's lexeme.
     */
    @Override
    public void execute() {
        tokenBuilder.cleanLexeme();
    }
}
