package programmers.lv0;

public class StringMergeByBigger {

    public static void main(String[] args) {
        System.out.println(solution(99, 123));
    }


    public static int solution(int a, int b) {
        String aType = String.valueOf(a) + String.valueOf(b);
        String bType = String.valueOf(b) + String.valueOf(a);

        int aTypeInt = Integer.parseInt(aType);
        int bTypeInt = Integer.parseInt(bType);

        return Math.max(aTypeInt, bTypeInt);
    }
}
