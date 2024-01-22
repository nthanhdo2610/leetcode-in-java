import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MissingLetters {

    public static void findMissingLetters(String sentence) {

        char[] ch = sentence.toLowerCase().toCharArray();

//        Map<Character, Integer> letters = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
//            letters.put(c, 0);
            set.add(c);
        }

        for (char c : ch) {
            set.remove(c);
//            letters.remove(c);
        }

//        letters.keySet().forEach(System.out::print);
        set.forEach(System.out::print);

    }

    public static void main(String[] args) {
        String inputSentence = "The quick brown fox jumps over the lazy dog";

        // Call the method to find and print missing letters
        findMissingLetters("inputSentence");
    }
}
