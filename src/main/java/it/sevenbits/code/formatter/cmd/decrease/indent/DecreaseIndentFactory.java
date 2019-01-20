package it.sevenbits.code.formatter.cmd.decrease.indent;

import it.sevenbits.code.formatter.IndentManager;
import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.formatter.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;

/**
 * Class DecreaseIndentFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class DecreaseIndentFactory implements ICommandFactory {

    private IndentManager indentManager;

    /**
     * Constructor.
     *
     * @param indentManager - IndentManager to pass.
     */
    public DecreaseIndentFactory(final IndentManager indentManager) {
        this.indentManager = indentManager;
    }

    /**
     * Creates DecreaseIndent command.
     *
     * @param token  - IToken to pass to DecreaseIndent command.
     * @param writer - IWriter to pass to DecreaseIndent command.
     */
    @Override
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new DecreaseIndent(indentManager);
    }
}
