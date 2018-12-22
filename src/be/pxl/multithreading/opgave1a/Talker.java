package be.pxl.multithreading.opgave1a;

public class Talker extends Thread {
    private int id;

    public Talker(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("My id is " + id);
            try{
                Thread.sleep(500);
            }catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
