package javalearn.interview;

import java.util.Scanner;

public class StaticInitializer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        calculateParellelogram(x, y);
    }

    private static void calculateParellelogram(int x, int y) {
        if (x < 1 || y < 1) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            System.out.println(x * y);
        }
    }
}
