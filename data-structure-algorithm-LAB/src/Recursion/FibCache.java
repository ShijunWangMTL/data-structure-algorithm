package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class FibCache {

    FibCache() {
        fibsCached.add(0L); // #0
        fibsCached.add(1L); // #1
    }

    private ArrayList<Long> fibsCached = new ArrayList<>(); // NOT a HashMap !
    private int fibsCompCount = 2;
    // in a correct caching implementation fibsCompCount will end up the same as fibsCached.size();

    public long getNthFib(int n) {
        n--;
        if (n < 0) {
            throw new IllegalArgumentException("Value can not be less than 1");
        }
        return computeNthFib(n);
    }

    // You can find implementation online, recursive or non-recursive.
    // For 100% solution you should use values in fibsCached as a starting point
    // instead of always starting from the first two values of 0, 1.
    private long computeNthFib(int n) {
 /*       //-----------1.recursion
        if (n < fibsCompCount) {
            return fibsCached.get(n);
        } else {
            long newFib = computeNthFib(fibsCompCount - 1) + computeNthFib(fibsCompCount - 2);
            fibsCached.add(newFib);
            fibsCompCount++;
            return computeNthFib(n);
        }*/

        //-----------2.loop
            for (int index = fibsCached.size();index<=n;index++){
                long val = fibsCached.get(index-1)+fibsCached.get(index-2);
                fibsCached.add(val);
                fibsCompCount++;
            }
            return fibsCached.get(n);
    }

    // How many fibonacci numbers has your code computed as opposed to returned cached?
    // Use this in your testing to make sure your caching actually works properly.
    public int getCountOfFibsComputed() {
        return fibsCompCount;
    }

    // returns all cached Fib values, comma-space-separated on a single line
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < fibsCached.size(); i++) {
            str += String.format("%s%d", i == 0 ? "" : ", ", fibsCached.get(i));
        }
        return str;
        // 2nd solution
/*        StringBuilder sb = new StringBuilder();
        for (long l : fibsCached) {
            sb.append(l == 0 ? "" : ", ");
            sb.append(l);

        }
        return sb.toString();*/
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FibCache test = new FibCache();

        /*System.out.println("fibsCompCount: " + test.fibsCompCount);
        System.out.println("getCountOfFibsComputed: " + test.getCountOfFibsComputed());
        test.getNthFib(2);
        test.getNthFib(2);
        System.out.println("getNthFib: " + test.getNthFib(3));
        System.out.println("getCountOfFibsComputed: " + test.getCountOfFibsComputed());
        System.out.println(test.toString());*/
    }

}
