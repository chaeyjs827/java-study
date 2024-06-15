package programmers.lv0;

public class MixedString {

    public static void main(String[] args) {
        System.out.println(solution("aaaaa", "bbbbb"));
    }

    public static String solution(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        int loopIndex = Math.max(str1Length, str2Length);

        String result  = "";
        for (int i = 0; i < loopIndex; i++) {
            if (str1Length >= i) {
                result += str1.charAt(i);
            }

            if (str2Length >= i) {
                result += str2.charAt(i);
            }
        }

        return result;
    }

}
