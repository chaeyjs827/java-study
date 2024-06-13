package programmers.lv0;

import java.util.Scanner;

public class SwitchUpperAndLowerString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        String result = "";
        for (char c : a.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result += String.valueOf(Character.toLowerCase(c));
            }

            if (Character.isLowerCase(c)) {
                result += String.valueOf(Character.toUpperCase(c));
            }
        }

        System.out.println(result);

    }

}
