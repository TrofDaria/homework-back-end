package com.sevenbits;

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
    public void testFormatRedundantSpaces() {
        String expectedResult = "a {\n    b {\n        c;\n    }\n}";
        try {
            Reader reader = new Reader("target/classes/files/TooManyNewLines.java");
            Writer writer = new Writer();
            Formatter.format(reader, writer);
            String result = writer.getWritten();
            assertEquals("wrong result",
                    expectedResult, result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testFormatOneLine() {
        String expectedResult = "a {\n    ddd;\n    b {\n        ccc;\n    }\n    eee;\n}";

        try {
            Reader reader = new Reader("target/classes/files/OneLine.java");
            Writer writer = new Writer();
            Formatter.format(reader, writer);
            String result = writer.getWritten();
            assertEquals("wrong result",
                    expectedResult, result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testFormatOnlyParentheses() {
        String expectedResult = "{\n    {\n        {\n        }\n    }\n}";
        try {
            Reader reader = new Reader("target/classes/files/Parentheses.java");
            Writer writer = new Writer();
            Formatter.format(reader, writer);
            String result = writer.getWritten();
            assertEquals("wrong result",
                    expectedResult, result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}