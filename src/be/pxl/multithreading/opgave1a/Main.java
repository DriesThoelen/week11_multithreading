package be.pxl.multithreading.opgave1a;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Talker(100 + i).start();
        }
    }
}
