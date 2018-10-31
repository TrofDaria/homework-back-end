package com.sevenbits;


import com.sevenbits.interfaces.IReader;

import java.io.*;
import java.net.URL;

public class Reader implements IReader {
    private BufferedReader br;

    public Reader(final String path) throws IOException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
//        URL url = Reader.class.getResource(path);
//        br = new BufferedReader(new FileReader(url.getPath()));
    }


    public boolean hasNext() {
        try {
            return br.ready();
        } catch (IOException e) {
            return false;
        }
    }

    public char read() throws IOException {
        return (char) br.read();
    }
}
