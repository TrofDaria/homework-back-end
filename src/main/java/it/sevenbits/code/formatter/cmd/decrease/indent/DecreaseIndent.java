package it.sevenbits.code.formatter.cmd.decrease.indent;

import it.sevenbits.code.formatter.IndentManager;
import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.writer.WriterException;

/**
 * Class DecreaseIndent.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class DecreaseIndent implements ICommand {

    private IndentManager indentManager;

    /**
     * Constructor.
     *
     * @param indentManager - IndentManager to use.
     */
    public DecreaseIndent(final IndentManager indentManager) {
        this.indentManager = indentManager;
    }

    /**
     * Decreases indent value.
     *
     * @throws WriterException - throws when WriterException occurs, and the command cannot be executed.
     */
    @Override
    public void execute() throws WriterException {
        indentManager.decreaseIndent();
    }
}
