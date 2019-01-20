package it.sevenbits.code.formatter.cmd.increase.indent;

import it.sevenbits.code.formatter.IndentManager;
import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.writer.WriterException;

/**
 * Class IncreaseIndent.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class IncreaseIndent implements ICommand {

    private IndentManager indentManager;

    /**
     * Constructor.
     *
     * @param indentManager - IndentManager to pass to a AppendIndent.
     */
    public IncreaseIndent(final IndentManager indentManager) {
        this.indentManager = indentManager;
    }

    /**
     * Increases indent value.
     *
     * @throws WriterException - throws when WriterException occurs, and the command cannot be executed.
     */
    @Override
    public void execute() throws WriterException {
        indentManager.increaseIndent();
    }
}
