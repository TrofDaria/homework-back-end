package it.sevenbits.code;

import it.sevenbits.code.reader.FileReader;
import it.sevenbits.code.reader.ReaderException;
import it.sevenbits.code.writer.StringWriter;
import it.sevenbits.code.writer.WriterException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;


public class FormatterTest {
    private Formatter formatter;

    @Before
    public void setUp() {
        this.formatter = new Formatter();

    }

    @Test
    public void testFormatRedundantSpaces() throws ReaderException, WriterException {
        String expectedResult = "a {\n    b {\n        c;\n    }\n}";
        FileReader fileReader = new FileReader("src/test/resources/fixtures/TooManyNewLines.java");
        StringWriter stringWriter = new StringWriter();
        formatter.format(fileReader, stringWriter);
        String result = stringWriter.toString();
        assertEquals("wrong result",
                expectedResult, result);
    }

    @Test
    public void testFormatOneLine() throws ReaderException, WriterException {
        String expectedResult = "a {\n    ddd;\n    b {\n        ccc;\n    }\n    eee;\n}";
        FileReader fileReader = new FileReader("src/test/resources/fixtures/OneLine.java");
        StringWriter stringWriter = new StringWriter();
        formatter.format(fileReader, stringWriter);
        String result = stringWriter.toString();
        assertEquals("wrong result",
                expectedResult, result);
    }

    @Test
    public void testFormatOnlyParentheses() throws ReaderException, WriterException {
        String expectedResult = "{\n    {\n        {\n        }\n    }\n}";
        FileReader fileReader = new FileReader("src/test/resources/fixtures/Parentheses.java");
        StringWriter stringWriter = new StringWriter();
        formatter.format(fileReader, stringWriter);
        String result = stringWriter.toString();
        assertEquals("wrong result",
                expectedResult, result);

    }
}