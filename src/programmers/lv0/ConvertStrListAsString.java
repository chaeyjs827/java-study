package programmers.lv0;

public class ConvertStrListAsString {

    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};
    }

    public static String solution(String[] arr) {
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        return answer;
    }

}
