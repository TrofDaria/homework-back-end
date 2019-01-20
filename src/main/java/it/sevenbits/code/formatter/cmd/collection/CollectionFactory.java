package it.sevenbits.code.formatter.cmd.collection;

import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.formatter.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;

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
     * Creates CollectionCommand.
     *
     * @param token  - token to pass to all command factories.
     * @param writer - IWriter to pass to all command factories.
     */
    @Override
    public ICommand createCommand(final IToken token, final IWriter writer) {
        ArrayList<ICommand> commands = new ArrayList<>();
        for (ICommandFactory commandFactory : commandFactories) {
            commands.add(commandFactory.createCommand(token, writer));
        }
        return new CollectionCommand(commands);
    }
}
