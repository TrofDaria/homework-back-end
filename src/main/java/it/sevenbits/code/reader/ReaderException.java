package it.sevenbits.code.reader;

/**
 * Class ReaderException is a custom exception for readers.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class ReaderException extends Exception {
    /**
     * Constructor.
     *
     * @param message - message to receive
     */
    public ReaderException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message - message to receive
     * @param e - exception to handle
     */
    public ReaderException(final String message, final Exception e) {
        super(message, e);
    }
}
