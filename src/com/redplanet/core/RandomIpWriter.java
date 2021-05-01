package com.redplanet.core;

import java.io.IOException;
import java.util.Random;

public class RandomIpWriter {

    final private String filename;

    public RandomIpWriter(String filename) {
        this.filename = filename;
    }

    public void writeIps() {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            Random random = new Random();
            for (long i = 0; i < 2000000000; i++)
                fileWriter.nioWriteFile("192.168." + random.nextInt(10) +"."+ random.nextInt(255));

            fileWriter.nioWriteFile("5.6.8.9");
            fileWriter.nioWriteFile("5.6.65.9");
            fileWriter.nioWriteFile("255.255.255.255");
        } catch (IOException e) {
            System.out.println("Something wrong with file");
            e.printStackTrace();
        }
    }
}
