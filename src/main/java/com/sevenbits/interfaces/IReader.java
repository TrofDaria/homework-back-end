package com.sevenbits.interfaces;

import java.io.IOException;

public interface IReader {
    boolean hasNext();
    char read() throws IOException;
}
