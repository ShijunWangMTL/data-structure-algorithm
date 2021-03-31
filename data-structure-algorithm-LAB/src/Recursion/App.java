package Recursion;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //Fibonacci
        //(0),1,1,2,3,5,8,13,21,34...
        int n = 9;
        //  System.out.printf("The fibo of %d is %d", n, fibo(n));
        System.out.println();
        //factorial => 5! = 5*4*3*2*1
        // System.out.printf("The factorial of %d is %d", n, fact(n));

        /*System.out.println(pow(0,10));
        System.out.println(pow(1,10));
        System.out.println(pow(3,3));
        System.out.println(pow(3,-3));
        System.out.println(Math.pow(3,-3));*/

        System.out.println(countChars("deghiaahiggghihiaga")); //4
        System.out.println(countChars("agfadgs")); //0

        System.out.println(changeXY("xaaxxbbbxccyx"));
        System.out.println(replaceXY("xaaxxbbbxccyx"));
    }

    private static int fibo(int n) {
        //exit condition
        if (n == 1) return 1;
        if (n == 0) return 0;
        return fibo(n - 1) + fibo(n - 2);
    }

    private static int fact(int n) {
        if (n == 1 || n == 0) return 1;
        return n * fact(n - 1);
    }

    public static double pow(double base, int n) {
        if (n == 0) return 1;
        if (n == 1) return base;
        if (n < 0) {
            base = 1 / base;
            n = -n;
        }
        return base * pow(base, n - 1);
    }

    // find counts of "hi" from a string
    public static int countChars(String string) {
        if (string.contains("hi") == false) return 0;
        int index = string.indexOf("hi");
        countChars(string.substring(index + 2));
        return 1 + countChars(string.substring(index + 2));
    }

    // 2nd solution
    private static int countOfHi(String str) {
        if (str.length() < 2) {
            return 0;
        }
        if (str.substring(0, 1).equals("hi")) {
            return 1 + countOfHi(str.substring(2));
        }
        return countOfHi(str.substring(1));
    }

    // replace "x" by "y" in s given string
    public static String changeXY(String str) {
        if (str.contains("x") == false) return str;
        int index = str.indexOf("x");
        return str.substring(0, index) + "y" + changeXY(str.substring(index + 1));
    }

    //2nd solution
    public static String replaceXY(String str) {
        if (str.length() == 0) {
            return str;
        }
        if (str.charAt(0) == 'x') {
            return "y" + replaceXY(str.substring(1));
        }
        return str.charAt(0) + replaceXY(str.substring(1));
    }




}
