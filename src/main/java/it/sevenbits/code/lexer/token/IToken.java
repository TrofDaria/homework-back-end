package it.sevenbits.code.lexer.token;

/**
 * Interface IToken.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public interface IToken {

    /**
     * Returns token name.
     *
     * @return token name
     */
    String getName();

    /**
     * Returns a lexeme that the token contains.
     *
     * @return lexeme
     */
    String getLexeme();
}
