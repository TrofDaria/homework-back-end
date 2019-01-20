package it.sevenbits.code.formatter.sm;

import java.util.Objects;

/**
 * Class Pair.
 *
 * @param <T> first
 * @param <U> second
 */
public final class Pair<T, U> {

    private final T first;
    private final U second;

    /**
     * Constructor.
     *
     * @param first  - first element of pair.
     * @param second - second element of pair.
     **/
    public Pair(final T first, final U second) {
        this.first = first;
        this.second = second;
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
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
