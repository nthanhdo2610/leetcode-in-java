public class DecimalToWords {

    private static final String[] units = {
            "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"
    };

    private static final String[] teens = {
            "", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen",
            " Seventeen", " Eighteen", " Nineteen"
    };

    private static final String[] tens = {
            "", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"
    };

    private static final String[] thousands = {"", " Thousand", " Million", " Billion"};

    public static String convertToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + thousands[i] + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 10) {
            return units[num];
        } else if (num < 20) {
            return teens[num - 10];
        } else if (num < 100) {
            return tens[num / 10] + helper(num % 10);
        } else {
            return units[num / 100] + " Hundred" + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        int number = 1234567;
        String words = convertToWords(number);

        System.out.println("Number: " + number);
        System.out.println("In words: " + words);
    }
}
