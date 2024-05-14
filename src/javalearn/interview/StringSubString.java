package javalearn.interview;

public class StringSubString {

    public static void main(String[] args) {
        int start = 3;
        int end = 8;
        String str = "helloworld";

        printSubString(start, end, str);
    }

    private static void printSubString(int start, int end, String str) {
        System.out.println(str.substring(start, end));
    }

}
