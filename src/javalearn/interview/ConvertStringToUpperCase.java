package javalearn.interview;

import java.util.Scanner;

public class ConvertStringToUpperCase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String[] stringArray = getStringArray(str);
        printResult(stringArray);
    }

    private static String[] getStringArray(String str) {
        return str.split("-");
    }

    private static void printResult(String[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            string = string.substring(0, 1);
            string = string.toUpperCase();
            stringBuilder.append(string);
        }
        System.out.println(stringBuilder.toString());
    }


}
