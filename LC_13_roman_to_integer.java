public class LC_13_roman_to_integer {
    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && charToNum(s.charAt(i)) < charToNum(s.charAt(i + 1))) {
                result -= charToNum(s.charAt(i));
            } else {
                result += charToNum(s.charAt(i));
            }
        }
        return result;
    }

    public static int charToNum(char a) {
        return switch (a) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        String s = new String("XX");
        int ans = romanToInt(s);
        System.out.println("Integer: " + ans);
    }
}
