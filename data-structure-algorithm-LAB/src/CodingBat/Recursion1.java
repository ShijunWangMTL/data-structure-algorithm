package CodingBat;

public class Recursion1 {
    public static void main(String[] args) {
        System.out.println(changePi("xpix"));
        System.out.println(changePi("pipi"));
        System.out.println(changePi("pip"));

        System.out.println(count7(717));
        System.out.println(count7(7));
        System.out.println(count7(123));
    }

    ///https://codingbat.com/prob/p170924
    //Given a string, compute recursively (no loops) a new string
    // where all appearances of "pi" have been replaced by "3.14".

    private static String changePi(String str) {
        if (!str.contains("pi")) {
            return str;
        }
        int index = str.indexOf("pi");
        return str.substring(0, index) + "3.14" + changePi(str.substring(index + 2));
    }

    ///https://codingbat.com/prob/p101409
    // Given a non-negative int n, return the count of the occurrences of 7 as a digit,so for example 717 yields 2. (no loops).
    // Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
    private static int count7(int n) {
        if (n < 10) {
            if (n == 7) return 1;
            else return 0;
        }
        return count7(n % 10) + count7(n / 10);
    }


}
