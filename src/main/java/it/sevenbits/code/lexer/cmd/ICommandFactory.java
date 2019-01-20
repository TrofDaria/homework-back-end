package it.sevenbits.code.lexer.cmd;

import it.sevenbits.code.lexer.token.TokenBuilder;

/**
 * Interface ICommandFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public interface ICommandFactory {

    /**
     * Creates command.
     *
     * @param tokenBuilder - TokenBuilder to pass to command.
     * @param c            - char to pass to command.
     * @return created command.
     */
    ICommand createCommand(final TokenBuilder tokenBuilder, final char c);
}
