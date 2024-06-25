package programmers.lv0;

public class LastElement {

    // 정수 리스트 num_list가 주어질 때,
    // 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을
    // 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여
    // return하도록 solution 함수를 완성해주세요.

    public static void main(String[] args) {
        print(solution(new int[]{2, 1, 6, 5}));
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];

        int last = num_list[num_list.length - 1];  // 마지막 원소
        int lastb = num_list[num_list.length - 2];  // 마지막 원소에서 그 전 원소

        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
        if (last > lastb) {
            answer[num_list.length] = last - lastb;
        } else {
            answer[num_list.length] = last * 2;
        }

        return answer;
    }

//    public static int[] solution(int[] num_list) {
//        int numListLength = num_list.length;
//
//        int lastValue = 0;
//
//        if (numListLength < 2) {
//            return num_list;
//        }
//
//        if (num_list[numListLength - 1] > num_list[numListLength - 2]) {
//            lastValue = num_list[numListLength - 1] - num_list[numListLength - 2];
//        } else if (num_list[numListLength - 1] < num_list[numListLength - 2]) {
//            lastValue = num_list[numListLength - 1] * 2;
//        }
//
//        if (lastValue == 0) {
//            return num_list;
//        } else {
//            int[] answer = new int[numListLength + 1];
//            for (int i = 0; i < numListLength; i++) {
//                answer[i] = num_list[i];
//            }
//            answer[numListLength] = lastValue;
//            return answer;
//        }
//    }


}
