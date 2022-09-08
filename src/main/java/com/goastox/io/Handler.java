package com.goastox.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class Handler {

    private final String file;

    public Handler(String file){
        this.file = file;
    }

    public static final char DONE = '\uFFFF';
    public String init() throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null){
            buffer.append(line).append('\n');
        }
        reader.close();
        return buffer.toString();
    }

}
