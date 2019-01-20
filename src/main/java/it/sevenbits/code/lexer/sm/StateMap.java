package it.sevenbits.code.lexer.sm;

import it.sevenbits.code.lexer.SymbolRecognizer;

import java.util.HashMap;
import java.util.Map;

/**
 * Class StateMap defines states and transitions between them.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
class StateMap {

    private final Map<Pair<State, String>, State> states;
    private final SymbolRecognizer symbolRecognizer;

    /**
     * Constructor.
     */
    StateMap() {
        states = new HashMap<>();
        State tokenReady = new State("TOKEN_READY");
        State waiting = new State("WAITING");
        State stringLiteral = new State("STRING_LITERAL");
        State suspectingComment = new State("SUSPECTING_COMMENT");
        State singleLineComment = new State("SINGLE_LINE_COMMENT");
        State multilineComment = new State("MULTILINE_COMMENT");
        State suspectingEOMultilineComment = new State("SUSPECTING_END_OF_MULTILINE_COMMENT");
        symbolRecognizer = new SymbolRecognizer();

        states.put(new Pair<>(waiting, "QUOTE"), stringLiteral);
        states.put(new Pair<>(waiting, "OPEN_BRACE"), tokenReady);
        states.put(new Pair<>(waiting, "CLOSE_BRACE"), tokenReady);
        states.put(new Pair<>(waiting, "FORWARD-SLASH"), suspectingComment);
        states.put(new Pair<>(waiting, "NOT_SPECIAL"), tokenReady);
        states.put(new Pair<>(waiting, "ASTERISK"), tokenReady);
        states.put(new Pair<>(waiting, "NEW_LINE"), waiting);
        states.put(new Pair<>(waiting, "SPACE"), tokenReady);
        states.put(new Pair<>(waiting, "SEMICOLON"), tokenReady);

        states.put(new Pair<>(stringLiteral, "QUOTE"), tokenReady);

        states.put(new Pair<>(suspectingComment, "QUOTE"), stringLiteral);
        states.put(new Pair<>(suspectingComment, "OPEN_BRACE"), tokenReady);
        states.put(new Pair<>(suspectingComment, "CLOSE_BRACE"), tokenReady);
        states.put(new Pair<>(suspectingComment, "FORWARD-SLASH"), singleLineComment);
        states.put(new Pair<>(suspectingComment, "NOT_SPECIAL"), tokenReady);
        states.put(new Pair<>(suspectingComment, "ASTERISK"), multilineComment);
        states.put(new Pair<>(suspectingComment, "NEW_LINE"), waiting);
        states.put(new Pair<>(suspectingComment, "SPACE"), tokenReady);
        states.put(new Pair<>(suspectingComment, "SEMICOLON"), tokenReady);

        states.put(new Pair<>(singleLineComment, "NEW_LINE"), tokenReady);

        states.put(new Pair<>(multilineComment, "ASTERISK"), suspectingEOMultilineComment);

        states.put(new Pair<>(suspectingEOMultilineComment, "QUOTE"), multilineComment);
        states.put(new Pair<>(suspectingEOMultilineComment, "OPEN_BRACE"), multilineComment);
        states.put(new Pair<>(suspectingEOMultilineComment, "CLOSE_BRACE"), multilineComment);
        states.put(new Pair<>(suspectingEOMultilineComment, "FORWARD-SLASH"), tokenReady);
        states.put(new Pair<>(suspectingEOMultilineComment, "NOT_SPECIAL"), multilineComment);
        states.put(new Pair<>(suspectingEOMultilineComment, "ASTERISK"), multilineComment);
        states.put(new Pair<>(suspectingEOMultilineComment, "NEW_LINE"), multilineComment);
        states.put(new Pair<>(suspectingEOMultilineComment, "SPACE"), multilineComment);
        states.put(new Pair<>(suspectingEOMultilineComment, "SEMICOLON"), multilineComment);
    }

    /**
     * Returns initial state for machine.
     *
     * @return state.
     */
    State getStartState() {
        return new State("WAITING");
    }

    /**
     * Returns next state for machine.
     *
     * @param state - current state of machine.
     * @param c     - incoming character.
     * @return next state.
     */
    State getNextState(final State state, final char c) {
        return states.getOrDefault(new Pair<>(state, symbolRecognizer.recognize(c)), state);
    }
}
