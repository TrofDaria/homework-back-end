package it.sevenbits.code.formatter.cmd.append.space;

import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.writer.IWriter;
import it.sevenbits.code.writer.WriterException;

/**
 * Class AppendSpace.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class AppendSpace implements ICommand {

    private IWriter writer;

    /**
     * Constructor.
     *
     * @param writer - IWriter to use.
     */
    public AppendSpace(final IWriter writer) {
        this.writer = writer;
    }

    /**
     * Appends space.
     *
     * @throws WriterException - throws when WriterException occurs, and the command cannot be executed.
     */
    @Override
    public void execute() throws WriterException {
        writer.write(' ');
    }
}
