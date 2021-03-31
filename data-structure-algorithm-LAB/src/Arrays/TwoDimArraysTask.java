package Arrays;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TwoDimArraysTask {
    public static void main(String[] args) {
        int row, column;
        int[][] array2d;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the numbers of row and columns for the array separated by white space: ");
        try {
            row = input.nextInt();
            column = input.nextInt();
            if (row < 1 || column < 1) {
                throw new IllegalArgumentException("Value must not be less than 1");
            }
            array2d = new int[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    array2d[i][j] = (int) (Math.random() * 199 - 99);
                    System.out.printf("%s%-3d", j == 0 ? "" : ", ", array2d[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            // calculations
            int rowSum = 0, columnSum = 0, sum = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    rowSum += array2d[i][j];
                    sum += rowSum;
                }
                System.out.println("The sum of Row #" + i + ": " + rowSum);
            }

            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    columnSum += array2d[j][i];
                }
                System.out.println("The sum of Column #" + i + ": " + columnSum);
            }

            System.out.println("Sum of all numbers in the array: " + sum);

            int total = row * column;
            // standard deviation
            double mean = (double) sum / total;
            double sumForVariance = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    sumForVariance += Math.pow((array2d[i][i] - mean), 2);
                }
            }
            double variance = sumForVariance / total;
            double sd = Math.sqrt(variance);
            System.out.println("Standard Deviation: " + sd);
            System.out.printf("std is %.3f \n", sd);  // 3 decimal places

            // find pairs of numbers whose sum is prime number
            // find number#1 number#2 from Array2D, thinking of one-dimension array
            System.out.printf("\n%5s%5s%13s", "#1", "#2", "Sum(Prime)");
            System.out.println("\n-------------------------");
            for (int i = 0; i < total; i++) {
                for (int j = i + 1; j < total; j++) {
                    int number1, r1, c1, number2, r2, c2; // index for number#1 number#2
                    r1 = (int) (i / column);
                    c1 = i - r1 * column;
                    number1 = array2d[r1][c1];

                    r2 = (int) (j / column);
                    c2 = j - r2 * column;
                    number2 = array2d[r2][c2];

                    int sumOfPair = number1 + number2;
                    if (isPrime(sumOfPair)) {
                        System.out.printf("%5d%5d%12d\n", number1, number2, sumOfPair);
                    }
                }
            }

            /*// convert array2d to one-dimension array and find pairs
            System.out.println("-----------------------");
            int[] newArr = new int[total];
            int count = 0;
            while(count < total){
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        newArr[count] = array2d[i][j];
                        count++;
                    }
                }
            }
           // System.out.println(Arrays.toString(newArr));
            for (int i = 0; i < total; i++) {
                for (int j = i + 1; j < total; j++) {
                    int temp = newArr[i] + newArr[j];
                    if (isPrime(temp)) {
                        System.out.printf("%5d%5d%12d\n", newArr[i], newArr[j], temp);
                    }
                }
            }*/

        } catch (InputMismatchException exc) {
            System.out.println("Value must be integer");
            System.exit(0);
        } catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
            System.exit(0);
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        if (number < 2) {
            return false;
        }
        return true;
    }
}
