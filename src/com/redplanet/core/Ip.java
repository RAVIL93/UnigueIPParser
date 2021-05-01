package com.redplanet.core;

public class Ip implements Comparable<Ip>{
    String ip;
    long position;
    long counter = 1;


    public Ip(String ip , long position) {
        this.ip = ip;
        this.position = position;
    }


    @Override
    public int hashCode() {
        final String[] split = ip.split("\\.");
        int hashCode = 1;
        for (String s: split) {

            hashCode = 31 * hashCode + Integer.parseInt(s);
        }
        return hashCode;
    }




    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj))
            return true;
        else if (this.hashCode() == ((Ip) obj).hashCode())
            return true;
        else return this.ip.equals(((Ip) obj).getIp());
    }

    public String getIp() {
        return ip;
    }



    @Override
    public int compareTo(Ip ip) {
        if ( this.hashCode() < ip.hashCode() ) {
            return -1;
        } else if (this.hashCode() > ip.hashCode())
            return +1;
        return 0;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Ip = "+ ip;
    }
}
