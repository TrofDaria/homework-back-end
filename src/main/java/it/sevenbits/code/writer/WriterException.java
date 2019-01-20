package it.sevenbits.code.writer;

/**
 * Class WriterException is a custom exception for writers.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class WriterException extends Exception {

    /**
     * Constructor.
     *
     * @param message - message to receive.
     */
    public WriterException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message - message to receive.
     * @param e       - exception to handle.
     */
    public WriterException(final String message, final Exception e) {
        super(message, e);
    }
}