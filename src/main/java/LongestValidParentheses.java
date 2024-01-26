import java.util.Stack;

public class LongestValidParentheses {

    /**
     * <a href="https://leetcode.com/problems/longest-valid-parentheses/description/">32. Longest Valid Parentheses</a>
     */
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize with a sentinel value

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    // If the stack is empty, push the current index as a new sentinel
                    stack.push(i);
                } else {
                    // Calculate the length of the valid parentheses substring
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Example usage:
        String input = "(()";
        int result = longestValidParentheses(input);
        System.out.println("Length of the longest valid parentheses substring: " + result);
    }
}
