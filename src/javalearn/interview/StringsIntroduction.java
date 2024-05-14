package javalearn.interview;

public class StringsIntroduction {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "java";

        printSumStrings(str1, str2);
        printLexicographicalStatus(str1, str2);
        printUpperCase(str1, str2);
    }

    private static void printSumStrings(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        System.out.println(str1Length + str2Length);
    }

    private static void printLexicographicalStatus(String str1, String str2) {
        int lexicographicalStatus = str1.compareTo(str2);
        if (lexicographicalStatus > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void printUpperCase(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {

        }
        str1 = str1.substring(0, 1).toUpperCase() + str1.substring(1).toLowerCase();
        str2 = str2.substring(0, 1).toUpperCase() + str2.substring(1).toLowerCase();

        System.out.println(str1 + " " + str2);
    }


}
