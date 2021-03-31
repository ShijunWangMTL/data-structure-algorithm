package Recursion;

import java.util.InputMismatchException;
import java.util.Scanner;


public class FibCachedDemo {
    static Scanner input = new Scanner(System.in);
    static FibCache fibo = new FibCache();

    public static void main(String[] args) {
        while (true) {
            GetFibByIndex();
            System.out.println("Steps: " + fibo.getCountOfFibsComputed());
            System.out.println("Cache: " + fibo.toString());
        }
    }

    static int getInt() {
        int value = -1;
        while (true) {
            try {
                value = input.nextInt();
                return value;
            } // end try
            catch (InputMismatchException e) {
                input.next(); // consume the wrong value
                System.out.println("Enter an integer: ");
            } // catch
        } // end while
    } //end meth

    static void GetFibByIndex() {
        while (true) {
            System.out.println("Enter the number to find nth Fibonacci number:");
            try {
                int nth = getInt();
                System.out.printf("%dth Fibonacci number is: %d\n", nth, fibo.getNthFib(nth));
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
