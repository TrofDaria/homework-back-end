package it.sevenbits.code.lexer.cmd.collection;

import it.sevenbits.code.lexer.cmd.ICommand;
import it.sevenbits.code.lexer.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.TokenBuilder;

import java.util.ArrayList;

/**
 * Class CollectionFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class CollectionFactory implements ICommandFactory {

    private ArrayList<ICommandFactory> commandFactories;

    /**
     * Constructor.
     *
     * @param commandFactories - ArrayList of ICommandFactories.
     */
    public CollectionFactory(final ArrayList<ICommandFactory> commandFactories) {
        this.commandFactories = commandFactories;
    }

    /**
     * Creates Collection command.
     *
     * @param tokenBuilder - TokenBuilder to pass to Collection command.
     * @param c            - char to pass to Collection command.
     */
    @Override
    public ICommand createCommand(final TokenBuilder tokenBuilder, final char c) {
        ArrayList<ICommand> commands = new ArrayList<>();
        for (ICommandFactory commandFactory : commandFactories) {
            commands.add(commandFactory.createCommand(tokenBuilder, c));
        }
        return new CollectionCommand(commands);
    }
}
