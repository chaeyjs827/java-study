package programmers.lv0;

public class MultipleString {

    public static void main(String[] args) {
        System.out.println(solution("string", 3));
    }

    public static String solution(String my_string, int k) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < k; i++) {
            answer.append(my_string);
        }
        return answer.toString();
    }

}
