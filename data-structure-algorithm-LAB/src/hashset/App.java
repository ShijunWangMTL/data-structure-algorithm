package hashset;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        // hashSet doesn't accept duplicate values
        hashSet.contains(12);

        int[] numbers = new int[]{1,1,1,1,1,2,2,2,4,3,5,6};//use for loop to find unique numbers, count if different
        for(int i=0;i<numbers.length;i++){
            hashSet.add(numbers[i]);
        }
        System.out.println("size of array numbers: " + numbers.length); // 12
        System.out.println("size of hashset: " + hashSet.size()); // 6
    }
}

