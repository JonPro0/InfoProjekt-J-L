package util;

public class Util {

    public static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static boolean isNumeric(String strNum) {
        try {
            int zahl = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public static boolean validateNumber(int number){
        if(number > 1200){
            return false;
        }
        return true;
    }

    public static void sleep(int n) throws InterruptedException {
        Thread.sleep(n);
    }
}
