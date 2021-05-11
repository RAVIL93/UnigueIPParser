package com.redplanet.core;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class UniqIpParser {
    private final String filename;

    private final static int LINES_COUNT = 4;
    private final static int MAX_IP_VALUE = 8773442;

    public UniqIpParser(String filename) {
        this.filename = filename;
    }

    public void parse() {
        try (FileReader fileReader = new FileReader(filename)) {
            List<Ip> ips;


            Ip[] array1 = new Ip[MAX_IP_VALUE];
            Ip[] array2 = new Ip[MAX_IP_VALUE];
            Ip[] array3 = new Ip[MAX_IP_VALUE];
            Ip[] array4 = new Ip[MAX_IP_VALUE];

            System.out.println("Reading begin");
            while (!(ips = fileReader.nioReadFile(LINES_COUNT)).isEmpty()) {

                if (array1[ips.get(0).hashCode()] != null)
                    array1[ips.get(0).hashCode()].setCounter(array1[ips.get(0).hashCode()].getCounter() + 1);
                else
                    array1[ips.get(0).hashCode()] = ips.get(0);

                if (ips.size() > 1)
                    if (array2[ips.get(1).hashCode()] != null)
                        array2[ips.get(1).hashCode()].setCounter(array2[ips.get(1).hashCode()].getCounter() + 1);
                    else
                        array2[ips.get(1).hashCode()] = ips.get(1);

                if (ips.size() > 2)
                    if (array3[ips.get(2).hashCode()] != null)
                        array3[ips.get(2).hashCode()].setCounter(array3[ips.get(2).hashCode()].getCounter() + 1);
                    else
                        array3[ips.get(2).hashCode()] = ips.get(2);

                if (ips.size() > 3)
                    if (array4[ips.get(3).hashCode()] != null)
                        array4[ips.get(3).hashCode()].setCounter(array4[ips.get(3).hashCode()].getCounter() + 1);
                    else
                        array4[ips.get(3).hashCode()] = ips.get(3);

            }
            System.out.println("Reading done");

            for (int i = 0; i < MAX_IP_VALUE; i++) {

                int count = 0;
                Ip uniqueIp = null;

                if (array1[i] != null) {
                    uniqueIp = array1[i];
                    count += array1[i].getCounter();
                    //System.out.println(array1[i].getIp() + " count="+ array1[i].getCounter() );
                    if (count > 1)
                        continue;
                }

                if (array2[i] != null) {
                    uniqueIp = array2[i];
                    count += array2[i].getCounter();
                    //System.out.println(array2[i].getIp() + " count="+ array2[i].getCounter() );
                    if (count > 1)
                        continue;
                }


                if (array3[i] != null) {
                    uniqueIp = array3[i];
                    count += array3[i].getCounter();
                    //System.out.println(array3[i].getIp() + " count="+ array3[i].getCounter() );
                    if (count > 1)
                        continue;
                }

                if (array4[i] != null) {
                    uniqueIp = array4[i];
                    count += array4[i].getCounter();
                    //System.out.println(array4[i].getIp() + " count="+ array4[i].getCounter() );
                    if (count > 1)
                        continue;
                }

                if (uniqueIp != null && count == 1)
                    System.out.println(uniqueIp.getIp());

            }


//            uniqIps.stream()
//                    .filter(ip -> ip.getCount() == 1)
//                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Something wrong with file");
            e.printStackTrace();
        }
    }


}
