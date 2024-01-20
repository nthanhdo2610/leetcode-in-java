import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

    public static char findFirstNonRepeatedCharacter(String str) {
        char[] ch = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ch) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String inputString = "programming";
        char firstNonRepeatedChar = findFirstNonRepeatedCharacter(inputString);

        if (firstNonRepeatedChar != '\0') {
            System.out.println("The first non-repeated character is: " + firstNonRepeatedChar);
        } else {
            System.out.println("No non-repeated character found in the string.");
        }
    }
}
