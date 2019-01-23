package it.sevenbits.code.writer;

import it.sevenbits.code.reader.FileReader;
import it.sevenbits.code.reader.ReaderException;
import org.junit.Assert;
import org.junit.Test;

public class FileWriterTest {

    @Test
    public void testWrite() throws WriterException, ReaderException {
        FileWriter writer = new FileWriter("src/test/resources/fixtures/Symbol.java");
        char expected = 'b';
        writer.write('b');
        writer.close();
        FileReader reader = new FileReader("src/test/resources/fixtures/Comments.java");
        Assert.assertEquals(expected, reader.read());
    }
}
