package programmers.lv0;

public class ReturnValueByFlag {

    public static void main(String[] args) {
        System.out.println(solution(-4, 5, true));
    }

    public static int solution(int a, int b, boolean flag) {
        int answer = 0;

        if (flag) {
            answer = a + b;
        } else {
            answer = a - b;
        }

        return answer;
    }

}
