package it.sevenbits.code.formatter.cmd.append.space;

import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.formatter.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;

/**
 * Class AppendSpaceFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class AppendSpaceFactory implements ICommandFactory {

    /**
     * Creates command.
     *
     * @param token  - IToken to pass to a AppendSpace.
     * @param writer - IWriter to pass to a AppendSpace.
     */
    @Override
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new AppendSpace(writer);
    }
}
