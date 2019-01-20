package it.sevenbits.code.lexer.token;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class TokenBuilder creates token.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class TokenBuilder {

    private StringBuilder currentLexeme;
    private String name;

    /**
     * Constructor.
     */
    public TokenBuilder() {
        currentLexeme = new StringBuilder();
        name = "";
    }

    /**
     * Adds character to token's lexeme.
     *
     * @param c - character to add.
     */
    public void addToLexeme(final char c) {
        currentLexeme.append(c);
    }

    /**
     * Creates token.
     *
     * @return created token.
     */
    public IToken createToken() {
        defineTokenName();
        if (name.equals("NONE")) {
            return null;
        }
        return new Token(name, currentLexeme.toString());
    }

    /**
     * Defines token name based on lexeme.
     */
    private void defineTokenName() {
        Map<String, String> tokensName = new HashMap<>();
        tokensName.put("^\\{$", "OPEN_BRACE");
        tokensName.put("^}$", "CLOSE_BRACE");
        tokensName.put("(?s)^/\\*.*\\*/$", "MULTILINE_COMMENT");
        tokensName.put("^//.*$", "SINGLE_LINE_COMMENT");
        tokensName.put("^\".*\"$", "STRING_LITERAL");
        tokensName.put("^\\s$", "SPACE");
        tokensName.put("^;$", "SEMICOLON");
        tokensName.put("", "NONE");
        for (String regExp : tokensName.keySet()) {
            Pattern p = Pattern.compile(regExp);
            Matcher m = p.matcher(currentLexeme.toString());
            if (m.matches()) {
                name = tokensName.get(regExp);
                return;
            }
        }
        name = "NOT_RESERVED_SYMBOL";
    }

    /**
     * Cleans lexeme.
     */
    public void cleanLexeme() {
        currentLexeme = new StringBuilder();
    }
}
