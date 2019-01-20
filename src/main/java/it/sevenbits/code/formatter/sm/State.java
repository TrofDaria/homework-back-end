package it.sevenbits.code.formatter.sm;

import java.util.Objects;

/**
 * Class State.
 */
public class State {

    private final String currentState;

    /**
     * Constructor.
     *
     * @param currentState - initial state.
     */
    public State(final String currentState) {
        this.currentState = currentState;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return String
     */
    public String toString() {
        return currentState;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o - the reference object with which to compare.
     * @return true if the arguments are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        State state = (State) o;
        return Objects.equals(currentState, state.currentState);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(currentState);
    }
}