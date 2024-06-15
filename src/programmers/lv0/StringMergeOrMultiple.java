package programmers.lv0;

public class StringMergeOrMultiple {

    public static void main(String[] args) {
        System.out.println(solution(29, 919));
    }

    public static int solution(int a, int b) {
        String aType = String.valueOf(a) + String.valueOf(b);
        int aTypeInt = Integer.parseInt(aType);

        int bType = 2 * a * b;

        return Math.max(aTypeInt, bType);
    }
}
