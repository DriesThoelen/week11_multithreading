package be.pxl.multithreading.opgave1b;

import be.pxl.multithreading.opgave1a.Talker;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(new Talker(100 + i)).start();
        }
    }
}
