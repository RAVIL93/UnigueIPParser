package ru.redplanet.ipparser;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqIpParserTest {

    @Test
    public void parse_first() {

        UniqIpParser uniqIpParser = new UniqIpParser("ips.txt");
        long start = System.currentTimeMillis();
        uniqIpParser.parse();
        long end = System.currentTimeMillis();
        System.out.println("DEBUG: parse_first_test took " + (end - start) + " MilliSeconds");



    }
}