package CodingBat;

public class Recursion2 {
    public static void main(String[] args) {
        //  System.out.println(groupSum(4, new int[]{2, 4, 8}, 10)); // false, index out of bound
        // System.out.println(groupSum6(0, new int[]{5, 6, 2}, 8)); //true
        //System.out.println(groupSum5(0, new int[]{3, 5, 1}, 5)); //true
        // System.out.println(groupSumClump(0, new int[]{2, 4, 4, 8, 1}, 14)); //false
        System.out.println(splitArray(new int[]{2, 4, 4, 8, 1, 1}));//true
        System.out.println(splitArray(new int[]{2, 4, 2}));//true

        /*int[] arr = new int[]{0, 1, 2, 3, 4};
        for (int i = 0; i < arr.length / 2; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("\n" + arr.length / 2);*/

    }


    ///Given an array of ints, choose a group of some of the ints, such that the group sums to the given target.
// This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem,
// you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array,
// our convention is to consider the part of the array starting at index start and continuing to the end of the array.
// The caller can specify the whole array simply by passing start as 0. No loops are needed -- the recursive calls progress down the array.
//groupSum(0, [2, 4, 8], 10) → true
//groupSum(0, [2, 4, 8], 14) → true
//groupSum(0, [2, 4, 8], 9) → false
    public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        if (groupSum(start + 1, nums, target - nums[start])) {
            return true;
        }
        return groupSum(start + 1, nums, target);
    }

    public static boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        if (nums[start] == 6) {
            return groupSum6(start + 1, nums, target - 6);
        }
        if (groupSum6(start + 1, nums, target - nums[start])) {
            return true;
        }
        return groupSum6(start + 1, nums, target);
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        if (groupNoAdj(start + 2, nums, target - nums[start])) {
            return true;
        }
        return groupNoAdj(start + 1, nums, target);
    }

    public static boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        if (nums[start] % 5 == 0) {
            if (start < nums.length - 1 && nums[start + 1] == 1) {
                return groupSum5(start + 2, nums, target - nums[start]);
            }
            return groupSum5(start + 1, nums, target - nums[start]);
        }
        if (groupSum5(start + 1, nums, target - nums[start])) {
            return true;
        }
        return groupSum5(start + 1, nums, target);

    }

    public static boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        int count = 1;
        while (start + 1 < nums.length && nums[start] == nums[start + 1]) { //index 1 = index 2
            count++;//1+1=2
            start++;// 1+1=2
        }
        ////////////////////////
        if (groupSumClump(start + 1, nums, target - nums[start] * count)) { //1,[...],14-2=12
            return true;
        }
        return groupSumClump(start + 1, nums, target);
        ////////////////////////
        /*if (count != 1) {
            if (groupSumClump(start+1, nums, target - nums[start] * count)) { //2, [...], 12-4*2
                return true;
            } else {
                return groupSumClump(start + 1, nums, target);
            }
        }
        if (groupSumClump(start + 1, nums, target - nums[start])) { //1,[...],14-2=12
            return true;
        }
        return groupSumClump(start + 1, nums, target);*/
    }

    ///Given an array of ints, is it possible to divide the ints into two groups,
    // so that the sums of the two groups are the same.
    // Every int must be in one group or the other. Write a recursive helper method
    // that takes whatever arguments you like, and make the initial call
    // to your recursive helper from splitArray(). (No loops needed.)
    //splitArray([2, 2]) → true
    //splitArray([2, 3]) → false
    //splitArray([5, 2, 3]) → true
    //splitArray([2, 3, 4, 5]) → false
    public static boolean splitArray(int[] nums) {
        return splitArrayRecursion(0, nums, 0, 0);
    }

    public static  boolean splitArrayRecursion(int start, int[] nums, int group1, int group2) {
        if (start >= nums.length) {
            return group1 == group2;
        }
        if (splitArrayRecursion(start + 1, nums, group1 + nums[start], group2)) {
            return true;
        }
        return splitArrayRecursion(start + 1, nums, group1, group2 + nums[start]);
    }

    public boolean splitOdd10(int[] nums) {
        return split0dd10Recursion(0, nums, 0, 0);
    }

    /// the sum of one group is a multiple of 10, and the sum of the other group is odd.
    public boolean split0dd10Recursion(int start, int[] nums, int multiple10, int odd) {
        if (start >= nums.length) {
            return multiple10%10==0 && odd%2==1;
        }
        if (split0dd10Recursion(start + 1, nums, multiple10 + nums[start], odd)) {
            return true;
        }
        return split0dd10Recursion(start + 1, nums, multiple10, odd + nums[start]);



    }


}
