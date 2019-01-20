package it.sevenbits.code.lexer.cmd.collection;

import it.sevenbits.code.lexer.cmd.ICommand;

import java.util.ArrayList;

/**
 * Class CollectionCommand is a command that consists of other commands.
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
     * @param commands - ArrayList of commands.
     */
    CollectionCommand(final ArrayList<ICommand> commands) {
        this.commands = commands;
    }

    /**
     * Executes all commands.
     */
    @Override
    public void execute() {
        for (ICommand command : commands) {
            command.execute();
        }
    }
}
