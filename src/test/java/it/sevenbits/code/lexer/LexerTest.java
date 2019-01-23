package it.sevenbits.code.lexer;

import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.lexer.token.Token;
import it.sevenbits.code.reader.FileReader;
import it.sevenbits.code.reader.IReader;
import it.sevenbits.code.reader.ReaderException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class LexerTest {
    @Test
    public void testReadTokenBasic() throws ReaderException {
        IReader reader = new FileReader("src/test/resources/fixtures/OneLine.java");
        ILexer lexer = new Lexer(reader);//a{d;e;}
        ArrayList<IToken> expectedTokens = new ArrayList<IToken>();
        expectedTokens.add(new Token("NOT_RESERVED_SYMBOL", "a"));
        expectedTokens.add(new Token("OPEN_BRACE", "{"));
        expectedTokens.add(new Token("NOT_RESERVED_SYMBOL", "b"));
        expectedTokens.add(new Token("SEMICOLON", ";"));
        expectedTokens.add(new Token("NOT_RESERVED_SYMBOL", "c"));
        expectedTokens.add(new Token("SEMICOLON", ";"));
        expectedTokens.add(new Token("CLOSE_BRACE", "}"));

        List<IToken> tokens = new ArrayList<IToken>();

        while (lexer.hasMoreTokens()) {
            tokens.add(lexer.readToken());
        }

        assertEquals("wrong result: wrong size",
                expectedTokens.size(), tokens.size());

        for (int i = 0; i < expectedTokens.size(); i++) {

            assertEquals("wrong result",
                    expectedTokens.get(i).getName(), tokens.get(i).getName());

            assertEquals("wrong result",
                    expectedTokens.get(i).getLexeme(), tokens.get(i).getLexeme());
        }
    }

    @Test
    public void testReadTokenBraces() throws ReaderException {
        IReader reader = new FileReader("src/test/resources/fixtures/Braces.java");
        ILexer lexer = new Lexer(reader);
        ArrayList<IToken> expectedTokens = new ArrayList<IToken>();
        expectedTokens.add(new Token("OPEN_BRACE", "{"));
        expectedTokens.add(new Token("OPEN_BRACE", "{"));
        expectedTokens.add(new Token("OPEN_BRACE", "{"));
        expectedTokens.add(new Token("CLOSE_BRACE", "}"));
        expectedTokens.add(new Token("CLOSE_BRACE", "}"));
        expectedTokens.add(new Token("CLOSE_BRACE", "}"));

        ArrayList<IToken> tokens = new ArrayList<IToken>();

        while (lexer.hasMoreTokens()) {
            tokens.add(lexer.readToken());
        }

        assertEquals("wrong result",
                expectedTokens.size(), tokens.size());

        for (int i = 0; i < expectedTokens.size(); i++) {

            assertEquals("wrong result",
                    expectedTokens.get(i).getName(), tokens.get(i).getName());

            assertEquals("wrong result",
                    expectedTokens.get(i).getLexeme(), tokens.get(i).getLexeme());
        }
    }

    @Test
    public void testReadTokenStringLiterals() throws ReaderException {
        IReader reader = new FileReader("src/test/resources/fixtures/StringLiterals.java");
        ILexer lexer = new Lexer(reader);
        ArrayList<IToken> expectedTokens = new ArrayList<IToken>();
        expectedTokens.add(new Token("NOT_RESERVED_SYMBOL", "a"));
        expectedTokens.add(new Token("SPACE", " "));
        expectedTokens.add(new Token("STRING_LITERAL", "\"bbb\""));
        expectedTokens.add(new Token("STRING_LITERAL", "\"ccc\""));
        expectedTokens.add(new Token("CLOSE_BRACE", "}"));
        expectedTokens.add(new Token("STRING_LITERAL", "\"ddd\""));

        ArrayList<IToken> tokens = new ArrayList<IToken>();

        while (lexer.hasMoreTokens()) {
            tokens.add(lexer.readToken());
        }

        assertEquals("wrong result",
                expectedTokens.size(), tokens.size());

        for (int i = 0; i < expectedTokens.size(); i++) {

            assertEquals("wrong result",
                    expectedTokens.get(i).getName(), tokens.get(i).getName());

            assertEquals("wrong result",
                    expectedTokens.get(i).getLexeme(), tokens.get(i).getLexeme());
        }
    }

    @Test
    public void testReadTokenComments() throws ReaderException{
        IReader reader = new FileReader("src/test/resources/fixtures/Comments.java");
        ILexer lexer = new Lexer(reader);
        ArrayList<IToken> expectedTokens = new ArrayList<IToken>();
        expectedTokens.add(new Token("SINGLE_LINE_COMMENT", "//i'm single line comment!"));
        expectedTokens.add(new Token("MULTILINE_COMMENT", "/*i'm multiline comment!\n\n*/"));

        ArrayList<IToken> tokens = new ArrayList<IToken>();

        while (lexer.hasMoreTokens()) {
            tokens.add(lexer.readToken());
        }

        assertEquals("wrong result",
                expectedTokens.size(), tokens.size());

        for (int i = 0; i < expectedTokens.size(); i++) {

            assertEquals("wrong result",
                    expectedTokens.get(i).getName(), tokens.get(i).getName());

            assertEquals("wrong result",
                    expectedTokens.get(i).getLexeme(), tokens.get(i).getLexeme());
        }
    }


}