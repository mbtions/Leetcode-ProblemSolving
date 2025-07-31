class LC_12_integer_to_roman {
    public static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                roman.append(symbol[i]);
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        int num = 494;
        String answer = intToRoman(num);
        System.out.println("Answer: " + answer);
    }
}