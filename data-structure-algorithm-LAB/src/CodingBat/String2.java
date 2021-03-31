package CodingBat;

public class String2 {
    public static void main(String[] args) {
        System.out.println(repeatEnd("Hello", 3));
        System.out.println(repeatEnd("Hello", 2));
        System.out.println(repeatEnd("Hello", 1));

        System.out.println(oneTwo("abc"));
    }

    ///https://codingbat.com/prob/p152339
    //Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
    // You may assume that n is between 0 and the length of the string, inclusive.
    private static String repeatEnd(String str, int n) {
        if (n < 0 || n > str.length()) return "";
        int count = n;
        String end = str.substring(str.length() - n);
        String result = "";
        while (count > 0) {
            result += end;
            count--;
        }
        return result;
    }

    public static String oneTwo(String str) {
        if (str.length() < 3) {
            return "";
        } else {
            int group = str.length() / 3;

            String newStr = "";
            for (int i = 0; i < group; i++) {
                newStr += str.substring(i * 3 + 1, i * 3 + 3) + str.substring(i * 3, i * 3 + 1);
            }
            return newStr;
        }

    }


}
