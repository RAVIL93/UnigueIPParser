package com.redplanet.core;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Closeable {
    static int currentPosition = 0;

    BufferedReader reader = null;

    public FileReader(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Charset charset = StandardCharsets.UTF_8;
        try {
            reader = Files.newBufferedReader(path, charset);
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
    public List<Ip> nioReadFile(int linesCount) throws IOException {
        String s;
        int counter = 0;
        List<Ip> list = new ArrayList<>();

        while ((s = reader.readLine()) != null) {
            if (counter < linesCount) {
                list.add(new Ip(s, currentPosition++));
                counter++;

            } else break;
        }
        return list;
    }

    @Override
    public void close() throws IOException {
        if (reader != null)
            reader.close();
    }
}
