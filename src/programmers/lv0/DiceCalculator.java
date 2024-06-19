package programmers.lv0;

public class DiceCalculator {

    public static void main(String[] args) {
        System.out.println(solution(4, 4, 4));
    }

    public static int solution(int a, int b, int c) {
        int answer = 0;

        int depth1 = (a + b + c);
        int depth2 = ((a * a) + (b * b) + (c * c));
        int depth3 = ((a * a * a) + (b * b * b) + (c * c * c));

        int calucalteDepth2 = depth1 * depth2;
        int calucalteDepth3 = depth1 * depth2 * depth3;

        if (a == b && b == c) {
            return calucalteDepth3;
        }

        if ((a == b) || (b == c) || (c == a)){
            return calucalteDepth2;
        }

        return depth1;
    }

}
