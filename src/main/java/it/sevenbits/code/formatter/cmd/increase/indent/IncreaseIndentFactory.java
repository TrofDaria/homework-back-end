package it.sevenbits.code.formatter.cmd.increase.indent;

import it.sevenbits.code.formatter.IndentManager;
import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.formatter.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;

/**
 * Class IncreaseIndentFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class IncreaseIndentFactory implements ICommandFactory {

    private IndentManager indentManager;

    /**
     * Constructor.
     *
     * @param indentManager - IndentManager to pass.
     */
    public IncreaseIndentFactory(final IndentManager indentManager) {
        this.indentManager = indentManager;
    }

    /**
     * Creates IncreaseIndent command.
     *
     * @param token  - IToken to pass to IncreaseIndent command.
     * @param writer - IWriter to pass to IncreaseIndent command.
     */
    @Override
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new IncreaseIndent(indentManager);
    }
}
