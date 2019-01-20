package it.sevenbits.code.writer;

/**
 * Interface IWriter.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public interface IWriter {
    /**
     * Writes a character.
     *
     * @param ch - a character to write.
     * @throws WriterException - throws when failed to write char.
     */
    void write(char ch) throws WriterException;
}
