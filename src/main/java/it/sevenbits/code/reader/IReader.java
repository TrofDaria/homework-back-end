package it.sevenbits.code.reader;

import java.io.IOException;

/**
 * Interface IReader.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */

public interface IReader {
    /**
     * Function hasNext determines whether the next element to read exists.
     *
     * @return boolean
     */
    boolean hasNext();
    /**
     * Reads a character.
     *
     * @return char
     * @throws ReaderException - throws when failed to read char
     */
    char read() throws ReaderException;
}
