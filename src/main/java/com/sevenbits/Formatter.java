package com.sevenbits;


import com.sevenbits.interfaces.IReader;
import com.sevenbits.interfaces.IWriter;

import java.io.IOException;

public class Formatter {
    private static final int SPACE_COEFFICIENT = 4;

    static void format(final IReader reader, final IWriter writer) {
        int currentSpaceCoef = 0;
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
                currentSpaceCoef -= SPACE_COEFFICIENT;
                newLine = true;
            }
            if (newLine && currentChar != ' ' && currentChar != '\n') {
                writer.write('\n');
                for (int x = 0; x < currentSpaceCoef; x++) {
                    writer.write(' ');
                }
                newLine = currentChar == '}';
                previousChar = ' ';

            }
            if (currentChar == '{') {
                currentSpaceCoef += SPACE_COEFFICIENT;
                newLine = true;
            }
            if (currentChar == ';') {
                newLine = true;
            }
            if (!(currentChar == ' ' && previousChar == ' ') && currentChar != '\n') {
                writer.write(currentChar);
                previousChar = currentChar;
            }
        }
    }
}

