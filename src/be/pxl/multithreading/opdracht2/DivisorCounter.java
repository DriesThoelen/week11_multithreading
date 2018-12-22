package be.pxl.multithreading.opdracht2;

public class DivisorCounter extends Thread {

    private int minimum;
    private int maximum;
    private int maximumAantalDelers;
    private int getalMetMaximumAantalDelers;

    public DivisorCounter(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
        //calculate();
    }

    public void calculate() {
        maximumAantalDelers = 0;
        getalMetMaximumAantalDelers = 0;

        for (int i = minimum; i <= maximum; i++) {
            int aantalDelers = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    aantalDelers++;
                }
            }

            compare(i, aantalDelers);
        }
    }

    private void compare(int i, int aantalDelers) {
        if (aantalDelers > maximumAantalDelers) { //7560 als de voorwaarde is aantalDelers > maximumAantalDelers en 9240 als de voorwaarde is aantalDelers >= maximumAantalDelers
            maximumAantalDelers = aantalDelers;
            getalMetMaximumAantalDelers = i;
        }
    }

    public int getMaxNumber() {
        return getalMetMaximumAantalDelers;
    }

    public int getMaxDivisors() {
        return maximumAantalDelers;
    }

    @Override
    public void run() {
        this.calculate();
    }
}
