package javalearn.interview;

import java.util.Scanner;

public class IntToString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        //String s = String.valueOf(i);

        checkIntRange(i);
    }

    private static void checkIntRange(int i) {
        if (-100 <= i && i <= 100) {
            System.out.println("Good job");
        } else {
            System.out.println("Wrong answer");
        }
    }

}
