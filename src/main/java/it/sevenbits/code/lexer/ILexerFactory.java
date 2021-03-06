package it.sevenbits.code.lexer;

import it.sevenbits.code.reader.IReader;

/**
 * Interface ILexerFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public interface ILexerFactory {
    /**
     * Creates ILexer.
     *
     * @param reader - reader to pass in the ILexer
     * @return created ILexer
     */
    ILexer createLexer(IReader reader);
}
