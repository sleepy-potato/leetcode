class Solution {
    private int[] evaluate(String s, int start) {
        int total = 0;
        int curr = 0;
        int op = '+';
        int i = start;
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                int[] result = evaluate(s, i + 1);
                if (op == '-') result[0] = -result[0];
                total += result[0];
                i = result[1];
            }
            if (Character.isDigit(ch)) curr = curr * 10 + Character.getNumericValue(ch);
            if (ch == '+' || ch == '-' || ch == ')' || i == s.length() - 1) {
                if (op == '-') curr = -curr;
                total += curr;
                op = ch;
                curr = 0;
            }
            if (ch == ')') break;
        }
        return new int[]{total, i};
    }
    public int calculate(String s) {
        return evaluate(s, 0)[0];
    }
}
