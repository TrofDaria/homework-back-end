package com.sevenbits;

import com.sevenbits.interfaces.IWriter;

public class Writer implements IWriter {
    private StringBuilder sb;

    public Writer() {
        sb = new StringBuilder();
    }

    public void write(final char ch) {
        sb.append(ch);
    }

    public String getContent() {
        return sb.toString();
    }
}
