package it.sevenbits.code.lexer;

import it.sevenbits.code.reader.IReader;

/**
 * Interface ILexerFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class LexerFactory implements ILexerFactory {

    /**
     * Creates ILexer.
     *
     * @param reader - reader to pass in the ILexer
     */
    @Override
    public ILexer createLexer(final IReader reader) {
        return new Lexer(reader);
    }
}
