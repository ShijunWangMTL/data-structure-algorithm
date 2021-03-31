package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferenceListArrayList {
    //List a = new ArrayList<int>(); // error, type must be object
    ArrayList b = new ArrayList<Integer>();
    //List c = new List<Integer>(); // error, interface cannot be instaniated

    public static void main(String[] args) {
        int[] arr1 = new int[2];
        arr1[0] = 10;
        arr1[1] = 20;
        int[] arr2 = new int[]{1,2,3};
        int[] arr = arr1;
        System.out.println("arr: " + Arrays.toString(arr));
        arr = arr2;
        System.out.println("arr: " + Arrays.toString(arr));
    }

}
