package it.sevenbits.code;


import it.sevenbits.code.reader.ReaderException;
import it.sevenbits.code.writer.IWriter;
import it.sevenbits.code.reader.IReader;
import it.sevenbits.code.writer.WriterException;

import java.io.IOException;

/**
 * Class Formatter formats Java code.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class Formatter {
    private final int SPACE_ADDEND = 4;

    /**
     * Formats white spaces and new lines.
     *
     * @param reader - source of code to format
     * @param writer - storage for formatted code
     * @throws ReaderException - throws when reading exception occurs
     * @throws WriterException - throws when writing exception occurs
     */
    public void format(final IReader reader, final IWriter writer) throws ReaderException, WriterException {
        int currentSpaceCount = 0;
        char currentChar;
        char previousChar = ' ';
        boolean newLine = false;
        while (reader.hasNext()) {
                currentChar = reader.read();
            if (currentChar == '}') {
                currentSpaceCount -= SPACE_ADDEND;
                newLine = true;
            }
            if (newLine && ((currentChar != ' ' && currentChar != '\n'))) {
                writer.write('\n');
                for (int x = 0; x < currentSpaceCount; x++) {
                    writer.write(' ');
                }
                newLine = currentChar == '}';
                previousChar = ' ';

            }
            if (currentChar == '{') {
                currentSpaceCount += SPACE_ADDEND;
                if (previousChar != ' ') {
                    writer.write(' ');
                }
                newLine = true;
            }
            if (currentChar == ';') {
                newLine = true;
            }
            if ((!(currentChar == ' ' && previousChar == ' ') && currentChar != '\n')) {
                if( !(currentChar == ' ' && previousChar == '{') && !(currentChar == ' ' && previousChar == ';')) {
                writer.write(currentChar);
                previousChar = currentChar;
                }
            }
        }
    }
}

