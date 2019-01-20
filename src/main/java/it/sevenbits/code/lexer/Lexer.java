package it.sevenbits.code.lexer;

import it.sevenbits.code.lexer.sm.State;
import it.sevenbits.code.lexer.sm.StateTransition;
import it.sevenbits.code.lexer.cmd.CommandRepository;
import it.sevenbits.code.lexer.cmd.ICommand;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.lexer.token.TokenBuilder;
import it.sevenbits.code.reader.IReader;
import it.sevenbits.code.reader.ReaderException;


/**
 * Class Lexer performs lexical parsing.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class Lexer implements ILexer {
    private IReader reader;
    private StateTransition stateTransition;
    private IToken currentToken;
    private IToken prevToken;

    /**
     * Constructor.
     *
     * @param reader - determines the reader from which lexer will be taking chars to process.
     * @throws ReaderException - throws when reading exception occurs.
     */
    public Lexer(final IReader reader) throws ReaderException {
        this.reader = reader;
        stateTransition = new StateTransition();
        readToken();
    }

    /**
     * Reads token and returns it.
     *
     * @throws ReaderException - throws when reading exception occurs.
     */
    @Override
    public IToken readToken() throws ReaderException {
        if (hasMoreTokens()) {
            prevToken = currentToken;
        }
        State state = stateTransition.getStartState();
        State finalState = new State("TOKEN_READY");
        TokenBuilder tokenBuilder = new TokenBuilder();
        CommandRepository commandRepository = new CommandRepository(tokenBuilder);
        while (reader.hasNext() && !state.equals(finalState)) {
            char c = reader.read();
            ICommand command = commandRepository.getCommand(state, c);
            // TODO: как передать контекст? TokenBuilder? Аргумент в execute?
            command.execute();
            state = stateTransition.nextState(state, c);

        }
        currentToken = tokenBuilder.createToken();
        if (prevToken != null) {
            return prevToken;
        } else {
            return currentToken;
        }

    }

    /**
     * Determines whether there are more token exists.
     *
     * @return true if exists, false otherwise.
     */
    @Override
    public boolean hasMoreTokens() {
        return currentToken != null;
    }
}
