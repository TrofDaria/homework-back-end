package com.sevenbits;


import com.sevenbits.interfaces.IReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Class Reader reads from file.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */

public class Reader implements IReader {
    private BufferedReader br;

    /**
     * Constructor.
     *
     * @param path - path to the file
     * @throws IOException - throws exception when file cannot be open
     **/
    public Reader(final String path) throws IOException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
    }

    /**
     * Function hasNext determines whether the next element to read exists.
     *
     * @return boolean
     */
    public boolean hasNext() {
        try {
            return br.ready();
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Reads a character from file.
     *
     * @return char
     * @throws IOException - throws when the file cannot be opened
     */
    public char read() throws IOException {
        return (char) br.read();
    }
}
