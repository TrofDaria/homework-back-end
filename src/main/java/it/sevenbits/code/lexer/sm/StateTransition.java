package it.sevenbits.code.lexer.sm;

/**
 * Class StateTransition makes transitions between states.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
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
     * @param c - char is needed by state map to define next state.
     * @return next state.
     */
    public State nextState(final State state, final char c) {
        return stateMap.getNextState(state, c);
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

