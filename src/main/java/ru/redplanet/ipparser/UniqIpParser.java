package ru.redplanet.ipparser;
import java.io.IOException;
import java.util.List;

public class UniqIpParser {
    private final String filename;


    private final static int BUFFER_SIZE = 16;
    private final static int MAX_IP_HASH_VALUE = 8773442;

    public UniqIpParser(String filename) {
        this.filename = filename;
    }

    public void parse() {
        try (FileReader fileReader = new FileReader(filename)) {
            List<Ip> ips;
            Ip[][] arrays = new Ip[4][MAX_IP_HASH_VALUE];

            System.out.println("Reading begin");

            while (!(ips = fileReader.nioReadFile(BUFFER_SIZE)).isEmpty()) {
                int i = 0;
                for (; i < ips.size() - 3; i += 4) {
                    arrays[0][ips.get(i).hashCode()] = ips.get(i).increase();
                    arrays[1][ips.get(i + 1).hashCode()] = ips.get(i + 1).increase();
                    arrays[2][ips.get(i + 2).hashCode()] = ips.get(i + 2).increase();
                    arrays[3][ips.get(i + 3).hashCode()] = ips.get(i + 3).increase();
                }
                for (; i < ips.size(); i++) {
                    arrays[0][ips.get(i).hashCode()] = ips.get(i).increase();
                }
            }

            System.out.println("Reading done");

            for (int i = 0; i < MAX_IP_HASH_VALUE; i++) {
                int count = 0;
                Ip uniqueIp = null;
                for (int j = 0; j < 4; j++) {
                    if (count > 1) {
                        break;
                    } else if (arrays[j][i] != null) {
                        uniqueIp = arrays[j][i];
                        count += arrays[j][i].getCounter();
                    }
                }
                if (count == 1 && uniqueIp != null) {
                    System.out.println(uniqueIp.getIp());
                }
            }

        } catch (IOException e) {
            System.out.println("Something wrong with file");
            e.printStackTrace();
        }


    }


}
