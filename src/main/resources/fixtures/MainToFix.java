package it.sevenbits.code;

import it.sevenbits.code.reader.FileReader;
import it.sevenbits.code.writer.StringWriter;

public class MainToFix {

    public static void main(final String[] args) {
        try {
            FileReader fileReader = new FileReader("src/main/java/it/sevenbits/code/MainToFix.java");
            StringWriter stringWriter = new StringWriter();
            Formatter formatter = new Formatter();
            formatter.format(fileReader, stringWriter);
            System.out.print(stringWriter.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

