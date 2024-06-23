package programmers.lv0;

public class RegMatchExample {

    // 정규 표현식의 성능: 정규 표현식 매칭은 입력 길이에 비례하여 선형 시간 복잡도를 가집니다. 즉, 문자열의 길이가  n 일 때, 매칭 시간 복잡도는  O(n) 입니다.
    // 입력의 크기: 문자열 배열의 길이가 최대 10이므로, 전체 시간 복잡도는  O(10n) = O(n) 입니다. 이 경우  n 은 최대 200,000입니다.

    public static void main(String[] args) {
        String[] codes = {"GN152", "SD065", "GN15244", "39451", "GB15#", "152GB", "G195N", "tA823", "SD06", "GB"};
        int result = solution(codes);
        System.out.println("올바른 추천인 코드의 개수: " + result); // 예상 출력: 2
    }

    public static int solution(String[] codes) {
        int answer = 0;
        // 정규 표현식 패턴
        String pattern = "^[A-Z]{2}[0-9]{3}$";

        // 각 코드가 패턴에 맞는지 확인
        for (String code : codes) {
            if (code.matches(pattern)) {
                answer++;
            }
        }

        return answer;
    }
}
