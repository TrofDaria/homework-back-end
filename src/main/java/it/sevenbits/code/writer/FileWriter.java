package it.sevenbits.code.writer;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Class FileWriter writes to file.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class FileWriter implements IWriter, AutoCloseable {

    private BufferedWriter bw;

    /**
     * Constructor.
     *
     * @param path - a path to a file.
     * @throws WriterException - throws when failed to open file for writing.
     **/
    public FileWriter(final String path) throws WriterException {
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new WriterException("Can't open file: " + path + "for writing", e);
        }
    }

    /**
     * Writes character to the file.
     *
     * @param ch - a character to write
     * @throws WriterException - throws when failed to write char
     */
    public void write(final char ch) throws WriterException {
        try {
            bw.write(ch);
            bw.flush();
        } catch (IOException e) {
            throw new WriterException("Error writing from file", e);
        }
    }

    /**
     * Closes writer.
     *
     * @throws WriterException - throws when failed to close writer.
     */
    public void close() throws WriterException {
        try {
            bw.close();
        } catch (IOException e) {
            throw new WriterException("Error closing file", e);
        }
    }
}