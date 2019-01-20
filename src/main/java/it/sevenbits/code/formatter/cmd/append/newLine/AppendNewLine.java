package it.sevenbits.code.formatter.cmd.append.newLine;

import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.writer.IWriter;
import it.sevenbits.code.writer.WriterException;

/**
 * Class AppendNewLine.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class AppendNewLine implements ICommand {

    private IWriter writer;

    /**
     * Constructor.
     *
     * @param writer - IWriter to use.
     */
    public AppendNewLine(final IWriter writer) {
        this.writer = writer;
    }

    /**
     * Appends new line.
     *
     * @throws WriterException - throws when WriterException occurs, and the command cannot be executed.
     */
    @Override
    public void execute() throws WriterException {
        writer.write('\n');
    }
}
