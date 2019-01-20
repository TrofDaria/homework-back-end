package it.sevenbits.code;

import it.sevenbits.code.formatter.Formatter;
import it.sevenbits.code.lexer.LexerFactory;
import it.sevenbits.code.reader.FileReader;
import it.sevenbits.code.reader.IReader;
import it.sevenbits.code.writer.FileWriter;
import it.sevenbits.code.writer.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main application entry point.
 */
public class Main {

    final static private Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * Main function for app.
     *
     * @param args - console arguments.
     */
    public static void main(final String[] args) {
        if (args.length == 0) {
            LOGGER.error("Program arguments are not defined.");
            return;
        }
        try {
            IReader fileReader = new FileReader(args[0]);
            IWriter fileWriter = new FileWriter(args[1]);
            Formatter formatter = new Formatter(new LexerFactory());
            formatter.format(fileReader, fileWriter);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}

