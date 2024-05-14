package javalearn.interview;

import java.util.Scanner;

public class DataTypeArrange {

//    byte: -128 ~ 127
//    short: -32,768 ~ 32,767
//    int: -2,147,483,648 ~ 2,147,483,647
//    long: -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807

    private static final long BYTE_MIN = Byte.MIN_VALUE;
    private static final long BYTE_MAX = Byte.MAX_VALUE;
    private static final long SHORT_MIN = Short.MIN_VALUE;
    private static final long SHORT_MAX = Short.MAX_VALUE;
    private static final long INT_MIN = Integer.MIN_VALUE;
    private static final long INT_MAX = Integer.MAX_VALUE;
    private static final long LONG_MIN = Long.MIN_VALUE;
    private static final long LONG_MAX = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                printAvailableDataTypes(x);
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }

    private static void printAvailableDataTypes(long x) {
        printDataType(x, "byte", BYTE_MIN, BYTE_MAX);
        printDataType(x, "short", SHORT_MIN, SHORT_MAX);
        printDataType(x, "int", INT_MIN, INT_MAX);
        printDataType(x, "long", LONG_MIN, LONG_MAX);
    }

    private static void printDataType(long x, String dataType, long min, long max) {
        if (x >= min && x <= max) {
            System.out.println("* " + dataType);
        }
    }}