import java.util.Stack;

public class DecodeString {
    /**
     * <a href="https://leetcode.com/problems/decode-string/description/">394. Decode String</a>
     */
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                char c = stack.pop();
                StringBuilder encoded = new StringBuilder();
                while (c != '[') {
                    encoded.insert(0, c);
                    c = stack.pop();
                }
                StringBuilder countStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    countStr.insert(0, stack.pop());
                }
                String decoded = decode(encoded.toString(), Integer.parseInt(countStr.toString()));
                for (int j = 0; j < decoded.length(); j++) {
                    stack.add(decoded.charAt(j));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }

    static String decode(String encoded, int k) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < k; i++) {
            decoded.append(encoded);
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        DecodeString decoder = new DecodeString();
        String input = "3[a2[c]]";
        String result = decoder.decodeString(input);
        System.out.println(result); // Output: "accaccacc"
    }
}
