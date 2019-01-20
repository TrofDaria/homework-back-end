package it.sevenbits.code.formatter.cmd.append.lexeme;

import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.formatter.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;

/**
 * Class AppendLexemeFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class AppendLexemeFactory implements ICommandFactory {

    /**
     * Creates command.
     *
     * @param token  - IToken to pass to a AppendLexeme.
     * @param writer - IWriter to pass to a AppendLexeme.
     */
    @Override
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new AppendLexeme(token, writer);
    }
}
