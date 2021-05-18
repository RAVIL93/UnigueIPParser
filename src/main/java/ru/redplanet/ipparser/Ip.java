package ru.redplanet.ipparser;

public class Ip implements Comparable<Ip> {
    String ip;
    long counter;

    public Ip(String ip) {
        this.ip = ip;
    }

    @Override
    public int hashCode() {
        final String[] split = ip.split("\\.");
        int hashCode = 1;
        for (String s : split) {
            hashCode = 31 * hashCode + Integer.parseInt(s);
        }
        return hashCode;
    }


    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        } else if (this.hashCode() == obj.hashCode()) {
            return true;
        } else {
            return this.ip.equals(((Ip) obj).getIp());
        }

    }

    public String getIp() {
        return ip;
    }

    public long getCounter() {
        return counter;
    }

    @Override
    public int compareTo(Ip ip) {
        if (this.hashCode() < ip.hashCode()) {
            return -1;
        } else if (this.hashCode() > ip.hashCode()) {
            return 1;
        }
        return 0;
    }

    public Ip increase() {
        this.counter++;
        return this;
    }

    @Override
    public String toString() {
        return "Ip = " + ip;
    }
}
