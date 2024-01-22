public class DecimalToWords {

    public static String[] units = new String[]{"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    public static String[] teens = new String[]{"", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    public static String[] tens = new String[]{"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    public static String HUNDRED = "Hundred ";
    public static String[] thousands = new String[]{"", "Thousand ", "Million ", "Billion "};

    public static String convertToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        StringBuilder words = new StringBuilder();

        while (num > 0) {
            if (num % 1000 > 0) {
                words.insert(0, converter(num % 1000) + thousands[i]);
            }
            num /= 1000;
            i++;
        }

        return words.toString().trim();
    }

    private static String converter(int num) {
        if (num == 0) return "";
        if (num < 10) return units[num];
        if (num < 20) return teens[num - 10];
        if (num < 100) return tens[num / 10] + converter(num % 10);
        else return units[num / 100] + HUNDRED + converter(num % 100);
    }

    public static void main(String[] args) {
        int number = 1234567;
        String words = convertToWords(number);

        System.out.println("Number: " + number);
        System.out.println("In words: " + words);
    }
}
