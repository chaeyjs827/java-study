package programmers.lv0;

public class StringModeProcess {

    public static void main(String[] args) {
        System.out.println(solution("abc1abc1abc"));
    }

    public static String solution(String code) {
        String answer = "";

        boolean isMode = false;

        if (code.isEmpty()) {
            return "EMPTY";
        }

        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1') {
                if (isMode) {
                    isMode = false;
                } else {
                    isMode = true;
                }
                continue;
            }

            if (!isMode && i % 2 == 0) {
                answer += code.charAt(i);
            }

            if (isMode && i % 2 ==1) {
                answer += code.charAt(i);
            }
        }

        return answer;
    }

    private static String solution1(String code) {
        StringBuilder ret = new StringBuilder();
        int mode = 0;

        for (int idx = 0; idx < code.length(); idx++) {
            char currentChar = code.charAt(idx);
            if (currentChar == '1') {
                mode = 1 - mode; // mode를 0에서 1로, 1에서 0으로 바꿈
            } else {
                if (mode == 0 && idx % 2 == 0) {
                    ret.append(currentChar);
                } else if (mode == 1 && idx % 2 == 1) {
                    ret.append(currentChar);
                }
            }
        }

        return ret.length() > 0 ? ret.toString() : "EMPTY";
    }

}
