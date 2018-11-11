package it.sevenbits.code;

import it.sevenbits.code.reader.FileReader;
import it.sevenbits.code.reader.ReaderException;
import it.sevenbits.code.writer.StringWriter;

import java.io.IOException;

/**
 * Main application entry point
 */
public class Main {
    /**
     * Main function for app
     *
     * @param args - console arguments
     */
    public static void main(final String[] args) {
        try {
            FileReader fileReader = new FileReader("src/main/resources/fixtures/MainToFix.java");
            StringWriter stringWriter = new StringWriter();
            Formatter formatter = new Formatter();
            formatter.format(fileReader, stringWriter);
            System.out.print(stringWriter.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

