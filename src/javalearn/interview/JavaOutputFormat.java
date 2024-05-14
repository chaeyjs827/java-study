package javalearn.interview;

import java.util.Scanner;

public class JavaOutputFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            StringBuilder s1 = new StringBuilder(sc.next());
            int x = sc.nextInt();

            int stringLength = s1.length();

            for (int j = 0; j < (15 - stringLength); j++) {
                s1.append(" ");
            }

            int xLength = getIntLength(x);


            String strX = String.valueOf(x);
            for (int k = 0; k < (3 - xLength); k++) {
                strX = "0" + strX;
            }

            System.out.println(s1 + strX);
            //Complete this line
        }
        System.out.println("================================");

    }

    private static int getIntLength(int x) {
        if (x == 0) {
            return 1;
        }
        return (int) (Math.log10(x) + 1);
    }
}
