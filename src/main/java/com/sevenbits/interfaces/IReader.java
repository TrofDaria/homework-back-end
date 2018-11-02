package com.sevenbits.interfaces;

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
     * @throws IOException - throws when the file cannot be opened
     */
    char read() throws IOException;
}
