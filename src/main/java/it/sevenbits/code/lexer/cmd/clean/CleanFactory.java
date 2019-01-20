package it.sevenbits.code.lexer.cmd.clean;

import it.sevenbits.code.lexer.cmd.ICommand;
import it.sevenbits.code.lexer.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.TokenBuilder;

/**
 * Class CleanFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class CleanFactory implements ICommandFactory {

    /**
     * Creates Clean command.
     *
     * @param tokenBuilder  - TokenBuilder to pass to Clean command.
     * @param c - char to pass to Clean command.
     */
    @Override
    public ICommand createCommand(final TokenBuilder tokenBuilder, final char c) {
        return new Clean(tokenBuilder, c);
    }
}
