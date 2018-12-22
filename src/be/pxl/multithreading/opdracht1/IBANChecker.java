package be.pxl.multithreading.opdracht1;

public class IBANChecker implements Runnable {
    private String IBANCode;

    public IBANChecker(String IBANCode) {
        this.IBANCode = IBANCode;
    }

    public boolean isIBANCodeValid() {
        String checkCode = IBANCode.replace(" ", "");
        int checksumNumber = Integer.parseInt(checkCode.substring(2,4));

        if (checksumNumber >= 2 && checksumNumber <= 98) {
            checkCode = checkCode.substring(4) + checkCode.substring(0, 4);
            checkCode = checkCode.replace("B", "11").replace("E", "14");
            long code = Long.parseLong(checkCode);
            if (code % 97 == 1) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void run() {

        if (isIBANCodeValid()) {
            System.out.println(IBANCode + ": valid");
        } else {
            System.out.println(IBANCode + ": not valid");
        }
    }
}
