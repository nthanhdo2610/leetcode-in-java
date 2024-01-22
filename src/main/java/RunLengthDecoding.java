public class RunLengthDecoding {

    public static String runLengthDecode(String encoded) {

        StringBuilder sb = new StringBuilder();
        int crr = 0;
        for (int i = 0; i < encoded.length(); i++) {
            if (!Character.isDigit(encoded.charAt(i))) {
                int l = Integer.parseInt(encoded.substring(crr, i));
                for (int j = 0; j < l; j++) {
                    sb.append(encoded.charAt(i));
                }
                crr = i + 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String encodedString = "10A2B10C";
        String decodedString = runLengthDecode(encodedString);
        System.out.println(decodedString);
    }
}
