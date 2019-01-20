package it.sevenbits.code.formatter.cmd.ignore;

import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.formatter.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;

/**
 * Class IgnoreFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class IgnoreFactory implements ICommandFactory {

    /**
     * Creates command.
     *
     * @param token  - IToken to pass to Ignore command.
     * @param writer - IWriter to pass to Ignore command.
     */
    @Override
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new Ignore();
    }
}
