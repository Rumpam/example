package com.company;


public class Facade {
    public static void main(String[] args){
        Computer computer = new Computer();
        computer.copy();
    }

}

class Computer {
    Power power = new Power();
    DVDrom dvd = new DVDrom();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvd.load();
        hdd.copyFromDvd(dvd);
    }
}

class Power {
    void on() {
        System.out.println("turnON");
    }
    void of() {
        System.out.println("turnOFF");
    }
}

class DVDrom {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }
    void load() {
        data = true;
    }
    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDvd(DVDrom dvd){
        if(dvd.hasData()){
            System.out.println("Происходит копирование");
        } else{
            System.out.println("Диск не загружен");
        }
    }
}