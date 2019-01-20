package it.sevenbits.code.formatter.cmd.append.newLine;

import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.formatter.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;

/**
 * Class AppendNewLineFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class AppendNewLineFactory implements ICommandFactory {

    /**
     * Creates command.
     *
     * @param token  - IToken to pass to a AppendNewLine.
     * @param writer - IWriter to pass to a AppendNewLine.
     */
    @Override
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new AppendNewLine(writer);
    }
}
