package it.sevenbits.code.formatter.sm;

import it.sevenbits.code.lexer.token.IToken;

/**
 * Class StateTransition.
 */
public final class StateTransition {

    private final StateMap stateMap;

    /**
     * Constructor.
     */
    public StateTransition() {
        this.stateMap = new StateMap();
    }

    /**
     * Returns next state according to this state map.
     *
     * @param state - State is needed by state map to define next state.
     * @param token - IToken is needed by state map to define next state.
     * @return next state.
     */
    public State nextState(final State state, final IToken token) {
        return stateMap.getNextState(state, token.getName());
    }

    /**
     * Returns initial state according to this state map.
     *
     * @return start state
     */
    public State getStartState() {
        return this.stateMap.getStartState();
    }
}

