package programmers.lv0;

public class CommonMultipleCheck {

    public static void main(String[] args) {
        System.out.println(solution(96, 2, 3));
    }

    public static int solution(int number, int n, int m) {
        if (number % n == 0 && number % m == 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
