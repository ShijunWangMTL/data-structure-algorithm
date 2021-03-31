package CodingBat;

import java.util.Arrays;

public class Array2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[]{1}));

        System.out.println(has22(new int[]{1, 2, 2})); //t
        System.out.println(has22(new int[]{1, 2, 1, 2})); //f
        System.out.println(has22(new int[]{2, 1, 2})); //f

        System.out.println(lucky13(new int[]{0, 2, 4})); //t
        System.out.println(lucky13(new int[]{1, 2, 3})); //f

        System.out.println(countEvens(new int[]{2, 1, 2, 3, 4})); //3
    }

    ///https://codingbat.com/prob/p105031
    // Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}.
    public static int[] shiftLeft(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        } else {
            int temp = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                nums[i] = nums[i + 1];
            }
            nums[nums.length - 1] = temp;
            return nums;
        }
    }

    ///https://codingbat.com/prob/p121853
    // Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
    public static boolean has22(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2) {
                if (nums[i + 1] == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    ///https://codingbat.com/prob/p194525
    // Given an array of ints, return true if the array contains no 1's and no 3's.
    public static boolean lucky13(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 || nums[i] == 3) {
                return false;
            }
        }
        return true;
    }

    ///https://codingbat.com/prob/p162010
    // Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder
    public static int countEvens(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    ///https://codingbat.com/prob/p196640
    // Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array.
    // Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.
    //bigDiff([10, 3, 5, 6]) → 7
    public static int bigDiff(int[] nums) {
        int smallest = nums[0], largest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);
        }
        return largest - smallest;
    }

    ///https://codingbat.com/prob/p136585
    // Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.
    //centeredAverage([1, 2, 3, 4, 100]) → 3
    //centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
    public static int centeredAverage(int[] nums) {
        int smallest = nums[0], largest = nums[0], sum = nums[0], avg = 0;
        for (int i = 1; i < nums.length; i++) {
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);
            sum += nums[i];
        }
        avg = (sum - smallest - largest) / (nums.length - 2);
        return avg;
    }


}
