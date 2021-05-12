package ru.redplanet.ipparser;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileWriter implements Closeable {

    BufferedWriter writer = null;

    public FileWriter(String fileName) {
        Path path = Paths.get(fileName);
        Charset charset = StandardCharsets.UTF_8;
        try {
            writer = Files.newBufferedWriter(path, charset);
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public void nioWriteFile(String str) throws IOException {
        if (str != null) {
            writer.write(str + "\n");
        }
    }

    @Override
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }
}
