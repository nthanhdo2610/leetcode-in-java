public class FirstUniqueCharacter {

    public static char firstUniqueChar(String sentence) {
        int l = sentence.length();
        for (int i = 0; i < l; i++) {
            char c = sentence.charAt(i);
            boolean isUnique = true;
            for (int j = i + 1; j < l; j++) {
                if (sentence.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                return c;
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        String input = "programming";
        char result = firstUniqueChar(input);
        System.out.println("First unique character: " + result);
    }
}
