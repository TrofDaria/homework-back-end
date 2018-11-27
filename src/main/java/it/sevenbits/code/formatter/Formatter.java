package it.sevenbits.code.formatter;


import it.sevenbits.code.lexer.ILexer;
import it.sevenbits.code.lexer.ILexerFactory;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.reader.IReader;
import it.sevenbits.code.reader.ReaderException;
import it.sevenbits.code.writer.IWriter;
import it.sevenbits.code.writer.WriterException;

/**
 * Class Formatter formats Java code.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class Formatter implements IFormatter {
    private ILexerFactory lexerFactory;
    private final int SPACE_ADDEND = 4;

    /**
     * Constructor.
     *
     * @param lexerFactory - lexerFactory creates lexers
     **/
    public Formatter(final ILexerFactory lexerFactory) {
        this.lexerFactory = lexerFactory;
    }

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
        boolean newLine = true;
        boolean firstLine = true;
        ILexer lexer = lexerFactory.createLexer(reader);
        StringBuilder sb = new StringBuilder();
        while (lexer.hasMoreTokens()) {
            IToken token = lexer.readToken();
            String lexeme = token.getLexeme();
            char[] lexemeChars = lexeme.toCharArray();
            if (token.getName() == "NONE") {
                continue;
            }
            if (newLine && !firstLine) {
                writer.write('\n');
                firstLine = false;
            }
            switch (token.getName()) {
                case "OPENING_PARENTHESIS":
                    if (newLine) {
                        addSpaces(currentSpaceCount, writer);
                    } else {
                        writer.write(' ');
                    }
                    for (char c : lexemeChars) {
                        writer.write(c);
                    }
                    newLine = true;
                    currentSpaceCount += SPACE_ADDEND;
                    break;
                case "CLOSING_PARENTHESIS":
                    currentSpaceCount -= SPACE_ADDEND;
                    if (!newLine) {
                        writer.write('\n');
                    }
                    addSpaces(currentSpaceCount, writer);
                    for (char c : lexemeChars) {
                        writer.write(c);
                    }
                    newLine = true;
                    break;
                case "END_OF_LINE":
                    if (newLine) {
                        addSpaces(currentSpaceCount, writer);
                    }
                    for (char c : lexemeChars) {
                        writer.write(c);
                    }
                    newLine = true;
                    break;
                case "WORD":
                    if (newLine) {
                        addSpaces(currentSpaceCount, writer);
                        newLine = false;
                    } else {
                        writer.write(' ');
                    }
                    for (char c : lexemeChars) {
                        writer.write(c);
                    }
                    break;

                default:

            }
            firstLine = false;
        }
    }

    /**
     * Adds white spaces.
     *
     * @param spaces - number of spaces to write
     * @param writer - writer which performs writing
     * @throws WriterException - throws when writing exception occurs
     */
    private void addSpaces(final int spaces, final IWriter writer) throws WriterException {
        for (int x = 0; x < spaces; x++) {
            writer.write(' ');
        }
    }
}


