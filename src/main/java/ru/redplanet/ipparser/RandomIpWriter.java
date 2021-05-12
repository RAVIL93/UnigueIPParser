package ru.redplanet.ipparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class RandomIpWriter {

    private static final String FIRST_IP_MASK = "192.168.";
    private final String filename;

    public RandomIpWriter(String filename) {
        this.filename = filename;
    }

    public void writeIps(long maxIpLines, Queue<String> uniqueIps) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            Random random = new Random();

            long delta = maxIpLines / (uniqueIps.size()-1);
            long position = delta;


            fileWriter.nioWriteFile(uniqueIps.poll());
            for (long i = 0; i < maxIpLines; i++) {
                fileWriter.nioWriteFile( FIRST_IP_MASK+ random.nextInt(255) + "." + random.nextInt(255));
                if (i == position-1) {
                    fileWriter.nioWriteFile(uniqueIps.poll());
                    position += delta ;
                }
            }



        } catch (IOException e) {
            System.out.println("Something wrong with file");
            e.printStackTrace();
        }
    }
}
