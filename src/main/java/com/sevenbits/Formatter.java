package com.sevenbits;


import com.sevenbits.interfaces.IReader;
import com.sevenbits.interfaces.IWriter;

import java.io.IOException;

/**
 * Class Formatter formats Java code.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class Formatter {
    private static final int SPACE_ADDEND = 4;

    /**
     * Formats white spaces and new lines.
     *
     * @param reader - source of code to format
     * @param writer - storage for formatted code
     */
    static void format(final IReader reader, final IWriter writer) {
        int currentSpaceCount = 0;
        char currentChar;
        char previousChar = ' ';
        boolean newLine = false;
        while (reader.hasNext()) {
            try {
                currentChar = reader.read();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return;
            }
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
            if ((!(currentChar == ' ' && previousChar == ' ') && currentChar != '\n') ) {
                if(!(currentChar == ' ' && previousChar == '{') && !(currentChar == ' ' && previousChar == ';' )) {
                writer.write(currentChar);
                previousChar = currentChar;
                }
            }
        }
    }
}

