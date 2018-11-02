package com.sevenbits;

import com.sevenbits.interfaces.IWriter;

/**
 * Class Writer writes to String.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */

public class Writer implements IWriter {
    private StringBuilder sb;


    /**
     * Constructor.
     **/
    public Writer() {
        sb = new StringBuilder();
    }

    /**
     * Writes character to StringBuilder.
     *
     * @param ch - a character to write
     **/
    public void write(final char ch) {
        sb.append(ch);
    }

    /**
     * Returns everything that has been written.
     *
     * @return String of StringBuilder
     */
    public String getWritten() {
        return sb.toString();
    }
}
