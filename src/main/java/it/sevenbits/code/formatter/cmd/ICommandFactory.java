package it.sevenbits.code.formatter.cmd;

import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;

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
     * @param token - IToken to pass to command.
     * @param writer - IWriter to pass to command.
     * @return created command.
     */
    ICommand createCommand(final IToken token, final IWriter writer);
}
