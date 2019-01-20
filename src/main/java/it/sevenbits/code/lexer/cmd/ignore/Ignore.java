package it.sevenbits.code.lexer.cmd.ignore;

import it.sevenbits.code.lexer.cmd.ICommand;
import it.sevenbits.code.lexer.token.TokenBuilder;

/**
 * Class ignore.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class Ignore implements ICommand {

    private char c;
    private TokenBuilder tokenBuilder;

    /**
     * Constructor.
     *
     * @param tokenBuilder to use.
     * @param c - char.
     */
    Ignore(final TokenBuilder tokenBuilder, final char c){ }

    /**
     * Do nothing.
     */
    @Override
    public void execute() {

    }
}
