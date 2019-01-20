package it.sevenbits.code.lexer;

import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.reader.ReaderException;

/**
 * Interface ILexer.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public interface ILexer {

    /**
     * Reads token and returns it.
     *
     * @return token.
     * @throws ReaderException - throws when reading exception occurs.
     */
    IToken readToken() throws ReaderException;

    /**
     * Determines whether there are more token exists.
     *
     * @return true if exists, false otherwise.
     */
    boolean hasMoreTokens();
}
