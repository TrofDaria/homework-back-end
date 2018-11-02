package com.sevenbits;

import java.io.IOException;

/**
 * Main application entry point
 */
public class Main {
    /**
     * Main function for app
     * @param args - console arguments
     */
    public static void main(final String[] args) {
        try {
            Reader reader = new Reader("target/classes/files/AbsoluteMess.java");
            Writer writer = new Writer();
            Formatter.format(reader, writer);
            System.out.print(writer.getWritten());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

