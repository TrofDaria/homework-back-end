package it.sevenbits.code.lexer.cmd;

import it.sevenbits.code.lexer.SymbolRecognizer;
import it.sevenbits.code.lexer.cmd.append.AppendFactory;
import it.sevenbits.code.lexer.cmd.clean.CleanFactory;
import it.sevenbits.code.lexer.cmd.collection.CollectionFactory;
import it.sevenbits.code.lexer.cmd.ignore.IgnoreFactory;
import it.sevenbits.code.lexer.sm.Pair;
import it.sevenbits.code.lexer.sm.State;
import it.sevenbits.code.lexer.token.TokenBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class CommandRepository.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class CommandRepository {

    private final ICommandFactory defaultCommandFactory = new AppendFactory();
    private final Map<Pair<State, String>, ICommandFactory> commandFactoryMap;
    private final SymbolRecognizer symbolRecognizer;
    private final TokenBuilder tokenBuilder;

    /**
     * Constructor.
     *
     * @param tokenBuilder - TokenBuilder to pass to commands.
     */
    public CommandRepository(final TokenBuilder tokenBuilder) {
        this.tokenBuilder = tokenBuilder;
        commandFactoryMap = new HashMap<>();
        State waiting = new State("WAITING");
        State stringLiteral = new State("STRING_LITERAL");
        State suspectingComment = new State("SUSPECTING_COMMENT");
        State singleLineComment = new State("SINGLE_LINE_COMMENT");
        State multilineComment = new State("MULTILINE_COMMENT");
        State suspectingEOMultilineComment = new State("SUSPECTING_END_OF_MULTILINE_COMMENT");

        ICommandFactory ignoreFactory = new IgnoreFactory();
        ICommandFactory cleanFactory = new CleanFactory();

        ArrayList<ICommandFactory> commandFactories = new ArrayList<ICommandFactory>();
        commandFactories.add(cleanFactory);
        commandFactories.add(defaultCommandFactory);
        ICommandFactory cleanAppendFactory = new CollectionFactory(commandFactories);

        symbolRecognizer = new SymbolRecognizer();

        commandFactoryMap.put(new Pair<>(waiting, "NEW_LINE"), ignoreFactory);

        commandFactoryMap.put(new Pair<>(stringLiteral, "NEW_LINE"), ignoreFactory);

        commandFactoryMap.put(new Pair<>(suspectingComment, "QUOTE"), cleanAppendFactory);
        commandFactoryMap.put(new Pair<>(suspectingComment, "OPEN_BRACE"), cleanAppendFactory);
        commandFactoryMap.put(new Pair<>(suspectingComment, "CLOSE_BRACE"), cleanAppendFactory);
        commandFactoryMap.put(new Pair<>(suspectingComment, "FORWARD-SLASH"), defaultCommandFactory);
        commandFactoryMap.put(new Pair<>(suspectingComment, "NOT_SPECIAL"), cleanAppendFactory);
        commandFactoryMap.put(new Pair<>(suspectingComment, "ASTERISK"), defaultCommandFactory);
        commandFactoryMap.put(new Pair<>(suspectingComment, "NEW_LINE"), ignoreFactory);
        commandFactoryMap.put(new Pair<>(suspectingComment, "SPACE"), ignoreFactory);

        commandFactoryMap.put(new Pair<>(singleLineComment, "NEW_LINE"), ignoreFactory);

    }

    /**
     * Returns command according to command map.
     *
     * @param state - State.
     * @param c     - char.
     * @return command.
     */
    public ICommand getCommand(final State state, final char c) {
        return commandFactoryMap.getOrDefault(new Pair<>(
                        state, symbolRecognizer.recognize(c)),
                defaultCommandFactory).createCommand(tokenBuilder, c);
    }

}
