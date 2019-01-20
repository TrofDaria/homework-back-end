package it.sevenbits.code.formatter.sm;

import java.util.HashMap;
import java.util.Map;

/**
 * Class StateMap.
 */
class StateMap {

    private final State defaultState = new State("NEW_LINE");
    private State initialState = new State("START");
    private final Map<Pair<State, String>, State> states;

    /**
     * Constructor.
     */
    StateMap() {
        states = new HashMap<>();
        State writingLine = new State("WRITING_LINE");
        State redundantSpaceSuspicion = new State("REDUNDANT_SPACE_SUSPICION");

        states.put(new Pair<>(initialState, "OPEN_BRACE"), defaultState);
        states.put(new Pair<>(initialState, "CLOSE_BRACE"), defaultState);
        states.put(new Pair<>(initialState, "MULTILINE_COMMENT"), defaultState);
        states.put(new Pair<>(initialState, "SINGLE_LINE_COMMENT"), defaultState);
        states.put(new Pair<>(initialState, "SPACE"), initialState);
        states.put(new Pair<>(initialState, "SEMICOLON"), initialState);
        states.put(new Pair<>(initialState, "NONE"), initialState);
        states.put(new Pair<>(initialState, "NOT_RESERVED_SYMBOL"), writingLine);

        states.put(new Pair<>(defaultState, "OPEN_BRACE"), defaultState);
        states.put(new Pair<>(defaultState, "CLOSE_BRACE"), defaultState);
        states.put(new Pair<>(defaultState, "MULTILINE_COMMENT"), defaultState);
        states.put(new Pair<>(defaultState, "SINGLE_LINE_COMMENT"), defaultState);
        states.put(new Pair<>(defaultState, "SPACE"), defaultState);
        states.put(new Pair<>(defaultState, "SEMICOLON"), defaultState);
        states.put(new Pair<>(defaultState, "NONE"), defaultState);
        states.put(new Pair<>(defaultState, "NOT_RESERVED_SYMBOL"), writingLine);

        states.put(new Pair<>(writingLine, "OPEN_BRACE"), defaultState);
        states.put(new Pair<>(writingLine, "CLOSE_BRACE"), defaultState);
        states.put(new Pair<>(writingLine, "MULTILINE_COMMENT"), defaultState);
        states.put(new Pair<>(writingLine, "SINGLE_LINE_COMMENT"), defaultState);
        states.put(new Pair<>(writingLine, "SPACE"), redundantSpaceSuspicion);
        states.put(new Pair<>(writingLine, "SEMICOLON"), defaultState);
        states.put(new Pair<>(writingLine, "NONE"), writingLine);
        states.put(new Pair<>(writingLine, "NOT_RESERVED_SYMBOL"), writingLine);

        states.put(new Pair<>(redundantSpaceSuspicion, "OPEN_BRACE"), defaultState);
        states.put(new Pair<>(redundantSpaceSuspicion, "CLOSE_BRACE"), defaultState);
        states.put(new Pair<>(redundantSpaceSuspicion, "MULTILINE_COMMENT"), defaultState);
        states.put(new Pair<>(redundantSpaceSuspicion, "SINGLE_LINE_COMMENT"), defaultState);
        states.put(new Pair<>(redundantSpaceSuspicion, "SPACE"), redundantSpaceSuspicion);
        states.put(new Pair<>(redundantSpaceSuspicion, "SEMICOLON"), defaultState);
        states.put(new Pair<>(redundantSpaceSuspicion, "NONE"), redundantSpaceSuspicion);
        states.put(new Pair<>(redundantSpaceSuspicion, "NOT_RESERVED_SYMBOL"), writingLine);
    }

    /**
     * Returns start state.
     *
     * @return start state.
     */
    State getStartState() {
        return initialState;
    }

    /**
     * Returns next state according to state map.
     *
     * @param state  - State.
     * @param signal - String.
     * @return next state.
     */
    State getNextState(final State state, final String signal) {
        return states.getOrDefault(new Pair<>(state, signal), defaultState);
    }
}
