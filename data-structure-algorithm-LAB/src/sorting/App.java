package sorting;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //Bubble sort
        //selection sort
        //insertion sort
        //quick sort

        System.out.println("original array: ");
        int[] numbers = new int[]{45, 12, 11, 10, 2, 5, 8};
        System.out.println(Arrays.toString(numbers));
        //Arrays.sort(numbers);
        System.out.println("bubble sort: ");
        bubbleSort(numbers);
        //System.out.println("selection sort: ");
        //selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    // bubble sort O(n^2)
    public static int[] bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) { // after 1st loop(index[0]), the first element is the smallest, then start from index[1]...
                if (numbers[i] > numbers[j]) {
                    //swap
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }

    //selection sort
    public static int[] selectionSort(int[] numbers) {
        int length = numbers.length;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < length; j++)
                if (numbers[j] < numbers[minIndex])
                    minIndex = j;
            // Swap the found minimum element with the first
            // element
            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
        }
        return numbers;
    }

    //insertion sort


    //quick sort

}
