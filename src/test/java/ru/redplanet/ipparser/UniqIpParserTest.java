package ru.redplanet.ipparser;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class UniqIpParserTest {


    @Before
    public void initializeIps() {

        RandomIpWriter ipWriter = new RandomIpWriter("ips.txt");
        Queue<String> uniqueIps = new LinkedList<>();
        uniqueIps.offer("4.5.7.8");
        uniqueIps.offer("8.8.8.8");
        uniqueIps.offer("12.5.7.4");
        uniqueIps.offer("33.5.7.4");

        long start = System.currentTimeMillis();
        ipWriter.writeIps(3000,uniqueIps);
        long end = System.currentTimeMillis();
        System.out.println("DEBUG: writeIps_test took " + (end - start) + " MilliSeconds");

    }


    @Test
    public void parse() {

        UniqIpParser uniqIpParser = new UniqIpParser("ips.txt");
        long start = System.currentTimeMillis();
        uniqIpParser.parse();
        long end = System.currentTimeMillis();
        System.out.println("DEBUG: parse_test took " + (end - start) + " MilliSeconds");

    }
}