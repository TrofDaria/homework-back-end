package it.sevenbits.code.writer;

/**
 * Class StringWriter writes to String.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class StringWriter implements IWriter {

    private StringBuilder sb;

    /**
     * Constructor.
     */
    public StringWriter() {
        sb = new StringBuilder();
    }

    /**
     * Returns everything that has been written.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return sb.toString();
    }

    /**
     * Writes character to String.
     *
     * @param ch - a character to write.
     * @throws WriterException - throws when failed to write char.
     */
    public void write(final char ch) throws WriterException {
        sb.append(ch);
    }
}
