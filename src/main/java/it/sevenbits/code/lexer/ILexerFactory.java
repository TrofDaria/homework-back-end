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
public interface ILexerFactory {

    /**
     * Creates ILexer.
     *
     * @param reader - reader to pass in the ILexer.
     * @return created ILexer.
     * @throws ReaderException - throws when ReaderException occurs.
     */
    ILexer createLexer(IReader reader) throws ReaderException;
}
