package it.sevenbits.code.formatter;

import it.sevenbits.code.StringWriter;
import it.sevenbits.code.lexer.LexerFactory;
import it.sevenbits.code.reader.FileReader;
import it.sevenbits.code.reader.IReader;
import it.sevenbits.code.reader.ReaderException;
import it.sevenbits.code.writer.IWriter;
import it.sevenbits.code.writer.WriterException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class FormatterTest {

    @Test
    public void testFormatRedundantSpaces() throws ReaderException, WriterException {
        String expectedResult = "a {\n    b {\n        c;\n    }\n}";
        IReader fileReader = new FileReader("src/test/resources/fixtures/TooManyNewLines.java");
        IWriter stringWriter = new StringWriter();
        Formatter formatter = new Formatter(new LexerFactory());
        formatter.format(fileReader, stringWriter);
        String result = stringWriter.toString();
        assertEquals("wrong result",
                expectedResult, result);
    }

    @Test
    public void testFormatOneLine() throws ReaderException, WriterException {
        String expectedResult = "a {\n    ddd;\n    b {\n        ccc;\n    }\n    eee;\n}";
        FileReader fileReader = new FileReader("src/test/resources/fixtures/OneLine.java");
        IWriter stringWriter = new StringWriter();
        Formatter formatter = new Formatter(new LexerFactory());
        formatter.format(fileReader, stringWriter);
        String result = stringWriter.toString();
        assertEquals("wrong result",
                expectedResult, result);
    }

    @Test
    public void testFormatOnlyParentheses() throws ReaderException, WriterException {
        String expectedResult = "{\n    {\n        {\n        }\n    }\n}";
        FileReader fileReader = new FileReader("src/test/resources/fixtures/Parentheses.java");
        IWriter stringWriter = new StringWriter();
        Formatter formatter = new Formatter(new LexerFactory());
        formatter.format(fileReader, stringWriter);
        String result = stringWriter.toString();
        assertEquals("wrong result",
                expectedResult, result);

    }

    @Test
    public void testFormatEmpty() throws ReaderException, WriterException {
        String expectedResult = "";
        FileReader fileReader = new FileReader("src/test/resources/fixtures/Empty.java");
        IWriter stringWriter = new StringWriter();
        Formatter formatter = new Formatter(new LexerFactory());
        formatter.format(fileReader, stringWriter);
        String result = stringWriter.toString();
        assertEquals("wrong result",
                expectedResult, result);

    }
}