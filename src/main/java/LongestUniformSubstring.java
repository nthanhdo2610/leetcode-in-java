public class LongestUniformSubstring {

    public static String findLongestUniformSubstring(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int length = 1;
        int crr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                crr++;
            } else {
                if (crr > length) {
                    length = crr;
                    start = i - crr;
                }
                crr = 1;
            }
        }
        if (crr > length) {
            start = s.length() - crr;
            length = crr;
        }
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        String input = "aabbbbccc";
        String longestUniformSubstring = findLongestUniformSubstring(input);

        System.out.println("Longest Uniform Substring: " + longestUniformSubstring);
    }
}
