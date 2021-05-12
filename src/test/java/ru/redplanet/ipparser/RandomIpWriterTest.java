package ru.redplanet.ipparser;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class RandomIpWriterTest {

    @Test
    public void writeIps_first() {

        RandomIpWriter ipWriter = new RandomIpWriter("ips.txt");
        Queue<String> uniqueIps = new LinkedList<>();
        uniqueIps.offer("4.5.7.8");
        uniqueIps.offer("8.8.8.8");
        uniqueIps.offer("12.5.7.4");
        uniqueIps.offer("33.5.7.4");

        long start = System.currentTimeMillis();
        ipWriter.writeIps(20,uniqueIps);
        long end = System.currentTimeMillis();
        System.out.println("DEBUG: writeIps_first_test took " + (end - start) + " MilliSeconds");

    }

    @Test
    public void writeIps_second() {

        RandomIpWriter ipWriter = new RandomIpWriter("ips.txt");
        Queue<String> uniqueIps = new LinkedList<>();
        uniqueIps.offer("4.5.7.8");
        uniqueIps.offer("8.8.8.8");
        uniqueIps.offer("12.5.7.4");
        uniqueIps.offer("33.5.7.4");

        long start = System.currentTimeMillis();
        ipWriter.writeIps(2000000000,uniqueIps);
        long end = System.currentTimeMillis();
        System.out.println("DEBUG: writeIps_second_test took " + (end - start) + " MilliSeconds");

    }
}