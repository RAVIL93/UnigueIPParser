package com.redplanet.core;

import java.io.IOException;
import java.util.Random;

public class Main {
    private static final String BIG_FILE = "ipmaps.txt";

    public static void main(String[] args) {

        //RandomIpWriter randomIpWriter = new RandomIpWriter(BIG_FILE);
        //randomIpWriter.writeIps();

        UniqIpParser uniqIpParser = new UniqIpParser(BIG_FILE);
        uniqIpParser.parse();

    }
}
