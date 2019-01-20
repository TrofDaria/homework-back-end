package it.sevenbits.code.lexer.cmd.ignore;

import it.sevenbits.code.lexer.cmd.ICommand;
import it.sevenbits.code.lexer.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.TokenBuilder;

/**
 * Class IgnoreFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class IgnoreFactory implements ICommandFactory {

    /**
     * Creates Ignore command.
     *
     * @param tokenBuilder  - TokenBuilder to pass to Ignore command.
     * @param c - char to pass to Ignore command.
     */
    @Override
    public ICommand createCommand(final TokenBuilder tokenBuilder, final char c) {
        return new Ignore(tokenBuilder, c);
    }
}
