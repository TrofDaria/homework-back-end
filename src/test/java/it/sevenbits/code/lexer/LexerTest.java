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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LexerTest {
    @Test
    public void testReadTokenBasic() throws ReaderException {
        IReader mockReader = mock(FileReader.class);
        ILexer lexer = new Lexer(mockReader);
        when(mockReader.read()).thenReturn( 'a');
        when(mockReader.hasNext()).thenReturn(true, true, false);
        List<IToken> expectedTokens = new ArrayList<IToken>();
        expectedTokens.add(new Token("WORD", "a"));

        List<IToken> tokens = new ArrayList<IToken>();

        while (lexer.hasMoreTokens()) {
            tokens.add(lexer.readToken());
        }

        assertEquals("wrong result: wrong size",
                expectedTokens.size(), tokens.size());

        for(int i=0; i< expectedTokens.size(); i++) {

            assertEquals("wrong result",
                    expectedTokens.get(i).getName(), tokens.get(i).getName());

            assertEquals("wrong result",
                    expectedTokens.get(i).getLexeme(), tokens.get(i).getLexeme());
        }
    }

    @Test
    public void testReadTokenParentheses() throws ReaderException{
        IReader reader = new FileReader("src/test/resources/fixtures/Parentheses.java");
        ILexer lexer = new Lexer(reader);
        ArrayList<IToken> expectedTokens = new ArrayList<IToken>();
        expectedTokens.add(new Token("OPENING_PARENTHESIS", "{"));
        expectedTokens.add(new Token("OPENING_PARENTHESIS", "{"));
        expectedTokens.add(new Token("OPENING_PARENTHESIS", "{"));
        expectedTokens.add(new Token("CLOSING_PARENTHESIS", "}"));
        expectedTokens.add(new Token("CLOSING_PARENTHESIS", "}"));
        expectedTokens.add(new Token("CLOSING_PARENTHESIS", "}"));

        ArrayList<IToken> tokens = new ArrayList<IToken>();

        while (lexer.hasMoreTokens()) {
            tokens.add(lexer.readToken());
        }

        assertEquals("wrong result",
                expectedTokens.size(), tokens.size());

        for(int i=0; i< expectedTokens.size(); i++) {

            assertEquals("wrong result",
                    expectedTokens.get(i).getName(), tokens.get(i).getName());

            assertEquals("wrong result",
                    expectedTokens.get(i).getLexeme(), tokens.get(i).getLexeme());
        }
    }
}