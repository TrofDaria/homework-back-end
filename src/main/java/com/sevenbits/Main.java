package com.sevenbits;

import java.io.IOException;

public class Main {
    public static void main(final String[] args) {
        try {
            Reader reader = new Reader("target/classes/files/AbsoluteMess.java");
            Writer writer = new Writer();
            Formatter.format(reader, writer);
            System.out.print(writer.getContent());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

