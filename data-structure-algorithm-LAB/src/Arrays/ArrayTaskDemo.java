package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTaskDemo {
    public static void main(String[] args) {
        int length;
        int[] userArray;
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the length of your array. The length should be an integer and no less than 1: ");

        /*try {
            length = input.nextInt();
            if (length < 1) {
                throw new IllegalArgumentException("Error: the value must be larger than 1");
            }
            userArray = new int[length];
            for(int i=0;i<length;i++) {
                userArray[i] = (int)((Math.random() * 100) + 1);
            }
            String arrayStr = Arrays.toString(userArray).replaceAll("\\[|\\]", "");
            System.out.println(arrayStr);
            // another way to print with comma
            for(int i=0;i<length;i++) {
                System.out.printf("%s%d", i==0 ? "" : ",", userArray[i]);
            }
        }
        catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
            System.exit(0);
        }*/
//=======================================
        if (!input.hasNextInt()) {
            System.out.println("The value you entered is not valid.");
            System.exit(0);
        }
        else {
            length = input.nextInt();
            if (length < 1) {
                System.out.println("The value you entered is not valid.");
                System.exit(0);
            }
            else {
                userArray = new int[length];
                for(int i=0;i<length;i++) {
                    userArray[i] = (int)((Math.random() * 100) + 1);
                }
//                String arrayStr = Arrays.toString(userArray).replaceAll("\\[|\\]", "");
//                System.out.println(arrayStr);
                // another way to print with comma
                for(int i=0;i<length;i++) {
                    System.out.printf("%s%d", i==0 ? "" : ", ", userArray[i]);
                }
                System.out.println();

                // find prime numbers
                int count = 0;
                System.out.print("Prime numbers in userArray: ");
                for (int n:userArray) {
                    for(int i=n;i>=1;i--) {
                        if(n%i==0) {
                            count += 1;
                        }
                    }
                    if(count==2) {
                        System.out.print(n + "  ");
                    }
                    count = 0;
                }
                System.out.println();
                // 2nd solution to find prime numbers, isPrime method
                boolean isFirst = true;
                for(int i=0;i<length;i++){
                    if(isPrime(userArray[i])){
                        System.out.printf("%s%d", isFirst ? "" : ",", userArray[i]);
                       // System.out.printf("%s%d"," ", userArray[i]);
                        isFirst = false;
                    }
                }

            }
        }


    }
    private static boolean isPrime(int number) {
        for(int i=2;i<number/2;i++) {
            if(number%i==0) {
                return false;
            }
        }
        if(number < 2 || number ==4) {
            return false;
        }
        return true;
    }
}
