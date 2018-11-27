package it.sevenbits.code.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


/**
 * Class FileReader reads from file.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */

public class FileReader implements IReader , AutoCloseable {
    private BufferedReader br;

    /**
     * Constructor.
     *
     * @param path - path to the file
     * @throws ReaderException - throws exception when file cannot be open
     **/
    public FileReader(final String path) throws ReaderException {
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new ReaderException(e.getMessage(), e);
        }
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
     * @throws ReaderException - throws when failed to read char from file
     */
    public char read() throws ReaderException {
        try {
            return (char) br.read();
        } catch (IOException e) {
            throw new ReaderException(e.getMessage(), e);
        }
    }

    /**
     * Closes reader.
     *
     * @throws ReaderException - throws when failed to close reader
     */
    public void close() throws ReaderException {
        try {
            br.close();
        } catch (IOException e) {
            throw new ReaderException(e.getMessage(), e);
        }
    }
}
