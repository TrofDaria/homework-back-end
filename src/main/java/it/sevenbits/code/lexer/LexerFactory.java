package it.sevenbits.code.lexer;

import it.sevenbits.code.reader.IReader;
import it.sevenbits.code.reader.ReaderException;

/**
 * Interface ILexerFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class LexerFactory implements ILexerFactory {

    /**
     * Creates Lexer.
     *
     * @param reader - reader to pass in the ILexer.
     * @return created Lexer.
     */
    @Override
    public ILexer createLexer(final IReader reader) throws ReaderException {
        return new Lexer(reader);
    }
}
