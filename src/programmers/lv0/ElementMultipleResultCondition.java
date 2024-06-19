package programmers.lv0;

import java.util.Arrays;

public class ElementMultipleResultCondition {

    public static void main(String[] args) {
        int[] num_list = {5, 7 ,8 ,3};
        System.out.println(solution(num_list));
    }

    public static int solution(int[] num_list) {
        int answer = 0;
        int sum = 0;
        int multiple = 1;
        for (int i : num_list) {
            sum += i;
            multiple = multiple * i;
        }

        int multipleSum = sum * sum;

        if (multiple < multipleSum) {
            answer = 1;
        }

        return answer;
    }

}
