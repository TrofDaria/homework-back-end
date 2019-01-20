package it.sevenbits.code.formatter.cmd.append.indent;

import it.sevenbits.code.formatter.IndentManager;
import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.formatter.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;

/**
 * Class AppendIndentFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class AppendIndentFactory implements ICommandFactory {

    private IndentManager indentManager;

    /**
     * Constructor.
     *
     * @param indentManager - IndentManager to pass to a AppendIndent.
     */
    public AppendIndentFactory(final IndentManager indentManager) {
        this.indentManager = indentManager;
    }

    /**
     * Creates command.
     *
     * @param token  - IToken to pass to a AppendIndent.
     * @param writer - IWriter to pass to a AppendIndent.
     */
    @Override
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new AppendIndent(indentManager, writer);
    }
}
