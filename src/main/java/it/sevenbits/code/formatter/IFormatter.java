package it.sevenbits.code.formatter;

import it.sevenbits.code.reader.IReader;
import it.sevenbits.code.reader.ReaderException;
import it.sevenbits.code.writer.IWriter;
import it.sevenbits.code.writer.WriterException;


/**
 * Interface IFormatter formats.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public interface IFormatter {
    /**
     * Formats.
     *
     * @param reader - source of code to format.
     * @param writer - storage for formatted code.
     * @throws ReaderException - throws when reading exception occurs.
     * @throws WriterException - throws when writing exception occurs.
     */
    void format(final IReader reader, final IWriter writer) throws ReaderException, WriterException;
}
