public class LongestUniformSubstring {

    public static String findLongestUniformSubstring(String input) {
        if (input == null || input.length() == 0) {
            return ""; // Return an empty string for an empty input or null input
        }

        int start = 0; // Starting index of the current substring
        int maxLength = 1; // Length of the longest uniform substring
        int currentLength = 1; // Length of the current uniform substring

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                currentLength++;
            } else {
                // If the current substring is longer than the longest one so far
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    start = i - maxLength; // Update the starting index of the longest substring
                }

                currentLength = 1; // Reset the length for the new character
            }
        }

        // Check the last substring in case it is the longest
        if (currentLength > maxLength) {
            maxLength = currentLength;
            start = input.length() - maxLength;
        }

        return input.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String input = "aabbbbcccdd";
        String longestUniformSubstring = findLongestUniformSubstring(input);

        System.out.println("Longest Uniform Substring: " + longestUniformSubstring);
    }
}
