package it.sevenbits.code.formatter.cmd.collection;

import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.writer.WriterException;

import java.util.ArrayList;

/**
 * Class CollectionCommand is a command that consists of other commands.* *
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class CollectionCommand implements ICommand {
    private ArrayList<ICommand> commands;

    /**
     * Constructor.
     *
     * @param commands - commands to execute.
     */
    public CollectionCommand(final ArrayList<ICommand> commands) {
        this.commands = commands;
    }

    /**
     * Executes commands.
     *
     * @throws WriterException - throws when WriterException occurs, and the command cannot be executed.
     */
    @Override
    public void execute() throws WriterException {
        for (ICommand command : commands) {
            command.execute();
        }
    }
}
