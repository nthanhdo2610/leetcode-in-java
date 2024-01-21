import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    /**
     * A pangram is a sentence that contains every letter of the alphabet at least once.
     * Write a Java program to determine if a given string is a pangram.
     *
     * @param sentence
     * @return boolean
     */
    public static boolean isPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLetter(sentence.charAt(i))) {
                set.add(sentence.charAt(i));
            }
        }
        return set.size() == 26;
    }

    public static void main(String[] args) {
        // Test cases
        String pangram1 = "The quick brown fox jumps over the lazy dog";
        String pangram2 = "Pack my box with five dozen liquor jugs";
        String nonPangram = "Hello, World!";

        System.out.println("Is pangram1 a pangram? " + isPangram(pangram1));
        System.out.println("Is pangram2 a pangram? " + isPangram(pangram2));
        System.out.println("Is nonPangram a pangram? " + isPangram(nonPangram));
    }
}
