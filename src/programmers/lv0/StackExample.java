package programmers.lv0;

public class StackExample {

    public static void main(String[] args) {
        String[] pars = { "[(){{()}}]", "([])", "[()]()[{}]", "(}", "{}", "[]", "()" };
        int[] result = solution(pars);

        for (int res : result) {
            System.out.print(res + " ");
        }
        // 예상 출력: 1 0 1 0 1 1 1
    }

    public static int[] solution(String[] pars) {
        int[] answer = new int[pars.length];

        for (int i = 0; i < pars.length; i++) {
            answer[i] = isValid(pars[i]) ? 1 : 0;
        }

        return answer;
    }

    private static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[' || ch == '{' || ch == '(') {
                stack[++top] = ch;
            } else {
                if (top == -1) {
                    return false;
                }

                char topChar = stack[top--];

                if (ch == ']' && topChar != '[') {
                    return false;
                } else if (ch == '}' && topChar != '{') {
                    return false;
                } else if (ch == ')' && topChar != '(') {
                    return false;
                }
            }

            if (top != -1) {
                char parentChar = stack[top];
                if ((parentChar == '(' && (ch == ']' || ch == '}')) ||
                        (parentChar == '{' && ch == ']')) {
                    return false;
                }
            }
        }

        return top == -1;
    }
}
