package be.pxl.multithreading.opgave1c;

public class Main {
    public static void main(String[] args) {
        Talker talker = new Talker(100);
        System.out.println(talker.getState());

        talker.start();
        System.out.println(talker.getState());

        try {
            talker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(talker.getState());
    }
}
