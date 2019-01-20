package it.sevenbits.code.reader;

/**
 * Class StringReader reads String.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class StringReader implements IReader {

    private String str;
    private int index;

    /**
     * Constructor.
     *
     * @param str - String to read.
     */
    public StringReader(final String str) {
        this.str = str;
        index = 0;
    }

    /**
     * Function hasNext determines whether the next element to read exists.
     *
     * @return true if next element exists, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return index < str.length();
    }

    /**
     * Reads a character from string.
     *
     * @return char.
     * @throws ReaderException - throws when failed to get char from String.
     */
    @Override
    public char read() throws ReaderException {
        return str.charAt(index++);
    }
}
