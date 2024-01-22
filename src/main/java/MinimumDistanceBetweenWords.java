public class MinimumDistanceBetweenWords {

    public static int minDistanceBetweenWords(String sentence, String w1, String w2) {
        String[] arr = sentence.split(" ");
        int i = 0, from = -1, to = -1, dist = Integer.MAX_VALUE;

        for (String s : arr) {
            if (s.contains(w1)) {
                from = i;
            }
            if (s.contains(w2)) {
                to = i;
            }
            i += s.length() + 1; // plus 1 for space;

            if (from >= 0 && to >= 0) {
                if (from > to) {
                    dist = Math.min(dist, from - (to + w2.length()));
                } else {
                    dist = Math.min(dist, to - (from + w1.length()));
                }
            }
        }

        return from == -1 || to == -1 ? -1 : dist;
    }


    public static void main(String[] args) {
        String sentence = "This is a sample sentence with sample words problem for a sample problem.";
        String word1 = "sample";
        String word2 = "problem";

        int result = minDistanceBetweenWords(sentence, word1, word2);

        if (result != -1) {
            System.out.println("The minimum distance between \"" + word1 + "\" and \"" + word2 + "\" is: " + result);
        } else {
            System.out.println("One or both words not found in the sentence.");
        }
    }
}
