package palindromeWithStack;

import java.util.Locale;
import java.util.Stack;

public class PalindromeWithStack {
    public static void main(String[] args) {
        // System.out.println(checkForPalindrome(""));
        System.out.println("abccba");
        System.out.println(checkForPalindrome("abccba"));
        System.out.println();
        System.out.println("Was it a car or a cat I saw?");
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        System.out.println();
        System.out.println("I did, did I?");
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println();
        System.out.println("hello");
        System.out.println(checkForPalindrome("hello"));
        System.out.println();
        System.out.println("Don't nod");
        System.out.println(checkForPalindrome("Don't nod"));

    }

    public static boolean checkForPalindrome(String str) {
        // to ignore upper/lower case
        str = str.toLowerCase();
        // create string to collect only letters to compare
        String original = "";
        Stack palindromeStack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            // check if letter or not. push letters into stack and ignore other characters
            if (Character.isLetter((str.charAt(i)))) {
                original += str.charAt(i);
                palindromeStack.push(str.charAt(i));
            }
        }
        // make the stack upside down, by removing top element from original stack and then adding it to the new String
        String upsideDown = "";
        while (!palindromeStack.isEmpty()) {
            upsideDown += palindromeStack.pop();
        }
        // compare upsideDown with original stack
        if (original.equals(upsideDown)) {
            return true;
        } else {
            return false;
        }
    }

}
