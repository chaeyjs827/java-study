package javalearn.interview;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.

        System.out.println("US: " + getUs(payment));
        System.out.println("India: " + getIndia(payment));
        System.out.println("China: " + getChina(payment));
        System.out.println("France: " + getFrance(payment));
    }

    private static String getUs(double payment) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(payment);
    }

    private static String getIndia(double payment) {
        NumberFormat formatter = new DecimalFormat("#,###.00");
        return "Rs." + formatter.format(payment);
    }

    private static String getChina(double payment) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        return format.format(payment);
    }

    private static String getFrance(double payment) {
        Locale locale = new Locale("fr", "FR");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        return format.format(payment);
    }

}
