package be.pxl.multithreading.opdracht1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path codesPath = Paths.get("data\\codes.txt");

        try (BufferedReader reader = Files.newBufferedReader(codesPath)) {

            String line = null;

            while ((line = reader.readLine()) != null) {
                new Thread(new IBANChecker(line)).start();
            }

        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
