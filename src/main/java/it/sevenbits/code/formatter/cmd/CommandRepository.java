package it.sevenbits.code.formatter.cmd;

import it.sevenbits.code.formatter.IndentManager;
import it.sevenbits.code.formatter.cmd.append.indent.AppendIndentFactory;
import it.sevenbits.code.formatter.cmd.append.lexeme.AppendLexemeFactory;
import it.sevenbits.code.formatter.cmd.append.newLine.AppendNewLineFactory;
import it.sevenbits.code.formatter.cmd.append.space.AppendSpaceFactory;
import it.sevenbits.code.formatter.cmd.collection.CollectionFactory;
import it.sevenbits.code.formatter.cmd.decrease.indent.DecreaseIndentFactory;
import it.sevenbits.code.formatter.cmd.ignore.IgnoreFactory;
import it.sevenbits.code.formatter.cmd.increase.indent.IncreaseIndentFactory;
import it.sevenbits.code.formatter.sm.Pair;
import it.sevenbits.code.formatter.sm.State;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


/**
 * Class CommandRepository.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class CommandRepository {

    private final ICommandFactory defaultFactory;
    private Map<Pair<State, String>, ICommandFactory> commandFactoryMap;
    private IWriter writer;

    /**
     * Constructor.
     *
     * @param indentManager - IndentManager to pass to command factories.
     * @param writer        - IWriter to pass to command factories.
     */
    public CommandRepository(final IndentManager indentManager, final IWriter writer) {
        this.writer = writer;
        commandFactoryMap = new HashMap<>();
        defaultFactory = new AppendIndentFactory(indentManager);

        State initialState = new State("START");
        State defaultState = new State("NEW_LINE");
        State writingLine = new State("WRITING_LINE");
        State redundantSpaceSuspicion = new State("REDUNDANT_SPACE_SUSPICION");

        ICommandFactory ignore = new IgnoreFactory();
        ICommandFactory appendLexeme = new AppendLexemeFactory();
        ICommandFactory appendNewLine = new AppendNewLineFactory();
        ICommandFactory decreaseIndent = new DecreaseIndentFactory(indentManager);
        ICommandFactory increaseIndent = new IncreaseIndentFactory(indentManager);
        ICommandFactory appendSpace = new AppendSpaceFactory();

        commandFactoryMap.put(new Pair<>(initialState, "OPEN_BRACE"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(defaultFactory, appendLexeme, increaseIndent))));
        commandFactoryMap.put(new Pair<>(initialState, "CLOSE_BRACE"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(decreaseIndent, defaultFactory, appendLexeme))));
        commandFactoryMap.put(new Pair<>(initialState, "MULTILINE_COMMENT"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(defaultFactory, appendLexeme))));
        commandFactoryMap.put(new Pair<>(initialState, "SINGLE_LINE_COMMENT"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(defaultFactory, appendLexeme))));
        commandFactoryMap.put(new Pair<>(initialState, "SPACE"), ignore);
        commandFactoryMap.put(new Pair<>(initialState, "SEMICOLON"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(defaultFactory, appendLexeme))));
        commandFactoryMap.put(new Pair<>(initialState, "NONE"), ignore);
        commandFactoryMap.put(new Pair<>(initialState, "NOT_RESERVED_SYMBOL"), new CollectionFactory(
                new ArrayList<>(Collections.singletonList(appendLexeme))));

        commandFactoryMap.put(new Pair<>(defaultState, "OPEN_BRACE"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendNewLine, defaultFactory, appendLexeme, increaseIndent))));
        commandFactoryMap.put(new Pair<>(defaultState, "CLOSE_BRACE"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendNewLine, decreaseIndent, defaultFactory, appendLexeme))));
        commandFactoryMap.put(new Pair<>(defaultState, "MULTILINE_COMMENT"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendNewLine, defaultFactory, appendLexeme))));
        commandFactoryMap.put(new Pair<>(defaultState, "SINGLE_LINE_COMMENT"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendNewLine, defaultFactory, appendLexeme))));
        commandFactoryMap.put(new Pair<>(defaultState, "SPACE"), ignore);
        commandFactoryMap.put(new Pair<>(defaultState, "SEMICOLON"), ignore);
        commandFactoryMap.put(new Pair<>(defaultState, "NONE"), ignore);
        commandFactoryMap.put(new Pair<>(defaultState, "NOT_RESERVED_SYMBOL"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendNewLine, defaultFactory, appendLexeme))));

        commandFactoryMap.put(new Pair<>(writingLine, "OPEN_BRACE"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendSpace, appendLexeme, increaseIndent))));
        commandFactoryMap.put(new Pair<>(writingLine, "CLOSE_BRACE"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendNewLine, decreaseIndent, defaultFactory, appendLexeme))));
        commandFactoryMap.put(new Pair<>(writingLine, "MULTILINE_COMMENT"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendLexeme))));
        commandFactoryMap.put(new Pair<>(writingLine, "SINGLE_LINE_COMMENT"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendLexeme))));
        commandFactoryMap.put(new Pair<>(writingLine, "SPACE"), ignore);
        commandFactoryMap.put(new Pair<>(writingLine, "SEMICOLON"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendLexeme))));
        commandFactoryMap.put(new Pair<>(writingLine, "NONE"), ignore);
        commandFactoryMap.put(new Pair<>(writingLine, "NOT_RESERVED_SYMBOL"), appendLexeme);

        commandFactoryMap.put(new Pair<>(redundantSpaceSuspicion, "OPEN_BRACE"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendSpace, appendLexeme, increaseIndent))));
        commandFactoryMap.put(new Pair<>(redundantSpaceSuspicion, "CLOSE_BRACE"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendNewLine, decreaseIndent, defaultFactory, appendLexeme))));
        commandFactoryMap.put(new Pair<>(redundantSpaceSuspicion, "MULTILINE_COMMENT"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendSpace, appendLexeme))));
        commandFactoryMap.put(new Pair<>(redundantSpaceSuspicion, "SINGLE_LINE_COMMENT"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendSpace, appendLexeme))));
        commandFactoryMap.put(new Pair<>(redundantSpaceSuspicion, "SPACE"), ignore);
        commandFactoryMap.put(new Pair<>(redundantSpaceSuspicion, "SEMICOLON"), new CollectionFactory(
                new ArrayList<>(Collections.singletonList(appendLexeme))));
        commandFactoryMap.put(new Pair<>(redundantSpaceSuspicion, "NOT_RESERVED_SYMBOL"), new CollectionFactory(
                new ArrayList<>(Arrays.asList(appendSpace, appendLexeme))));
    }

    /**
     * Returns command according to commands map.
     *
     * @param state - State.
     * @param token - IToken to pass to command.
     * @return command.
     */
    public ICommand getCommand(final State state, final IToken token) {
        return commandFactoryMap.getOrDefault(new Pair<>(state, token.getName()), defaultFactory).createCommand(token, writer);
    }
}
