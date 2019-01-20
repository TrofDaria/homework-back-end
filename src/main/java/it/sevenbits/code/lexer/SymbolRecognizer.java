package it.sevenbits.code.lexer;

import java.util.HashMap;
import java.util.Map;

/**
 * Class SymbolRecognizer.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class SymbolRecognizer {

    private final Map<Character, String> symbols;

    /**
     * Constructor.
     */
    public SymbolRecognizer() {
        symbols = new HashMap<>();
        symbols.put('\n', "NEW_LINE");
        symbols.put('{', "OPEN_BRACE");
        symbols.put('}', "CLOSE_BRACE");
        symbols.put('/', "FORWARD-SLASH");
        symbols.put('*', "ASTERISK");
        symbols.put('"', "QUOTE");
        symbols.put(' ', "SPACE");
        symbols.put(';', "SEMICOLON");
    }

    /**
     * Recognizes the given symbol.
     *
     * @param c - character to recognize.
     * @return character name or type.
     */
    public String recognize(final char c) {
        return symbols.getOrDefault(c, "NOT_SPECIAL");
    }
}
