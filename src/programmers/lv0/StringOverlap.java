package programmers.lv0;

public class StringOverlap {

    public static void main(String[] args) {
        System.out.println(solution("He11oWor1d", "lloWorl", 2));
    }

    public static String solution(String my_string, String overwrite_string, int s) {
        int myStringLength = my_string.length();
        int overwriteLength = overwrite_string.length();

        String frontString = my_string.substring(0, s);
        String backString = my_string.substring((s + overwriteLength), myStringLength);

        return frontString + overwrite_string + backString;
    }

}
