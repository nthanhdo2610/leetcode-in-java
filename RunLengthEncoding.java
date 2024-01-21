public class RunLengthEncoding {

    public static String encoding(String s) {
        if (s == null || s.length() < 2)
            return s;
        StringBuilder ans = new StringBuilder();
        char c = s.charAt(0);
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans.append(c).append(cnt);
                c = s.charAt(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        ans.append(c).append(cnt);
        return ans.toString();
    }

    public static void main(String[] args) {
        String input = "wwwwaaadexxxxxx";
        String encodedString = encoding(input);

        System.out.println("Original String: " + input); // wwwxaaadexxxxxx
        System.out.println("Encoded String: " + encodedString); // w4a3d1e1x6
    }
}
