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
public class FileReader implements IReader, AutoCloseable {

    private BufferedReader br;
    private int currentChar;

    /**
     * Constructor.
     *
     * @param path - path to the file.
     * @throws ReaderException - throws exception when file cannot be open.
     **/
    public FileReader(final String path) throws ReaderException {
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            currentChar = br.read();
        } catch (IOException e) {
            throw new ReaderException("Can't open file:" + path + " for reading", e);
        }
    }

    /**
     * Function hasNext determines whether the next element to read exists.
     *
     * @return true if next element exists, false otherwise.
     */
    public boolean hasNext() {
        return currentChar != -1;
    }

    /**
     * Reads a character from file.
     *
     * @return char
     * @throws ReaderException - throws when failed to read char from file.
     */
    public char read() throws ReaderException {
        try {
            int prevChar = currentChar;
            currentChar = br.read();
            return (char) prevChar;
        } catch (IOException e) {
            throw new ReaderException("Error reading from file", e);
        }
    }

    /**
     * Closes reader.
     *
     * @throws ReaderException - throws when failed to close reader.
     */
    @Override
    public void close() throws ReaderException {
        try {
            br.close();
        } catch (IOException e) {
            throw new ReaderException("Can't close file", e);
        }
    }
}
