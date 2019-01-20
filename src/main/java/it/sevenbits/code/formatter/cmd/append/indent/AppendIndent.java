package it.sevenbits.code.formatter.cmd.append.indent;

import it.sevenbits.code.formatter.IndentManager;
import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.writer.IWriter;
import it.sevenbits.code.writer.WriterException;

/**
 * Class AppendIndent.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class AppendIndent implements ICommand {

    private IndentManager indentManager;
    private IWriter writer;

    /**
     * Constructor.
     *
     * @param indentManager - IndentManager to use.
     * @param writer - IWriter to use.
     */
    public AppendIndent(final IndentManager indentManager, final IWriter writer) {
        this.indentManager = indentManager;
        this.writer = writer;
    }

    /**
     * Appends indent.
     *
     * @throws WriterException - throws when WriterException occurs, and the command cannot be executed.
     */
    @Override
    public void execute() throws WriterException {
        for (int i = 0; i < indentManager.getCurrentIndent(); i++) {
            writer.write(' ');
        }
    }
}
