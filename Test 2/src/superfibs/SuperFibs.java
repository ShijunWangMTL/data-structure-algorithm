package superfibs;

import java.util.HashMap;
import java.util.Map;

public class SuperFibs {
    public static void main(String[] args) {
        SuperFibs f = new SuperFibs();
        System.out.printf("1 : %d, steps %d\n", f.getNthFib(0), SuperFibs.stepsCount);
        System.out.printf("2 : %d, steps %d\n", f.getNthFib(1), SuperFibs.stepsCount);
        System.out.printf("3 : %d, steps %d\n", f.getNthFib(2), SuperFibs.stepsCount);
        System.out.printf("4 : %d, steps %d\n", f.getNthFib(3), SuperFibs.stepsCount);
        System.out.printf("5 : %d, steps %d\n", f.getNthFib(4), SuperFibs.stepsCount);
        System.out.printf("6 : %d, steps %d\n", f.getNthFib(5), SuperFibs.stepsCount);
        System.out.printf("7 : %d, steps %d\n", f.getNthFib(6), SuperFibs.stepsCount);
        System.out.printf("8 : %d, steps %d\n", f.getNthFib(200), SuperFibs.stepsCount);
    }

    private Map<Integer, Long> cache = new HashMap<>();
    public static int stepsCount = 1;

    public SuperFibs() {
        cache.put(0, 0L);
        cache.put(1, 1L);
        cache.put(2, 1L);
    }

    public long getNthFib(int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }
        return computeNthFib(n);
    }

    private long computeNthFib(int n) {
        //counting from the existing numbers of elements, increment till n
        for (int i = cache.size(); i <= n; i++) {
            long newFib = computeNthFib(i - 1) + computeNthFib(i - 2) + computeNthFib(i - 3);
            cache.put(i, newFib);
            stepsCount++;
        }
        return cache.get(n);
    }

}


