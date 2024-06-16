package programmers.lv0;

public class MultipleCheck {

    public static void main(String[] args) {
        System.out.println(solution(92, 2));
    }

    public static int solution(int num, int n) {
        if (num % n == 0) {
            return 1;
        }

        return 0;
    }

}
