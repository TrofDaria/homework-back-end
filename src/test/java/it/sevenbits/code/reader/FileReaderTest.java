package it.sevenbits.code.reader;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FileReaderTest {

    @Test (expected = ReaderException.class)
    public void testNotExistingFile() throws ReaderException{
        FileReader reader = new FileReader("");
    }

    @Test
    public void testClose() throws ReaderException{
        FileReader reader = new FileReader("src/test/resources/fixtures/Comments.java");
        reader.close();
        boolean thrown = false;
        try {
            reader.read();
        } catch (ReaderException e) {
            thrown = true;
        }
        assertTrue(thrown);

    }
}
