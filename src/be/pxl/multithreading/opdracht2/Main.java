package be.pxl.multithreading.opdracht2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        int rangeMin = 1;
        int rangeMax = 50000;

        System.out.println("Range [" + rangeMin + " - " + rangeMax + "]");

        DivisorCounter f = new DivisorCounter(rangeMin, rangeMax);
        f.start();

        try {
            f.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Getal: " + f.getMaxNumber());
        System.out.println("Aantal delers: " + f.getMaxDivisors());

        long after = System.currentTimeMillis();

        double seconds = (after - before) / 1000.0;
        System.out.printf("Single threaded berekening duurde %.3f seconden", seconds);

        System.out.println();
        System.out.println();
        System.out.println("---------------------------------");
        before = System.currentTimeMillis();

        int numThreads = 10;
        List<DivisorCounter> list = new ArrayList<>();
        for(int i=0;i<numThreads;i++) {
            /* Opdeling kan veel efficiënter (# bewerkingen groeit exponentieel) */
            /* Nu: opdeling van de range in <numThreads> gelijke delen */
            DivisorCounter worker = new DivisorCounter(1 + (rangeMax / numThreads) * i, (rangeMax / numThreads) * (i + 1));
            worker.start();
            list.add(worker);
        }

        for (DivisorCounter dc:list) {
            try {
                dc.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        System.out.println("Getal: " + list.stream().mapToInt(dc -> dc.getMaxNumber()).max().getAsInt());
        System.out.println("Aantal delers: " + list.stream().mapToInt(dc -> dc.getMaxDivisors()).max().getAsInt());

        after = System.currentTimeMillis();

        seconds = (after - before) / 1000.0;
        System.out.printf("Multi-threaded berekening duurde %.3f seconden", seconds);
    }
}
