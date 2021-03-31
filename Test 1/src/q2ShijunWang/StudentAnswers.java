package q2ShijunWang;

import java.util.ArrayList;

public class StudentAnswers {
    public static void main(String[] args) {
        String key = "cbab";
        String invalidKey = "";     // test invalid key
        String[] empty = new String[]{};    // test empty answer array
        String[] answers = new String[]{"abdb", "bacd", "abcd", "cbab", "cc"};

        // test empty answer array
        try {
            printResults(empty, key);
        } catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
        }
        System.out.println();

        // test invalid key
        try {
            printResults(answers, invalidKey);
        } catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
        }
        System.out.println();

        // test normal key and answer array with one invalid element
        try {
            printResults(answers, key);
        } catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
        }

    }

    private static void printResults(String[] answers, String key) {
        if (answers.length < 1) {
            throw new IllegalArgumentException("Error: no answers");
        }
        if (key.length() < 1) {
            throw new IllegalArgumentException("Error: invalid keys");
        }
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].length() != 4) {
                throw new IllegalArgumentException("Error: The number of answers does not match the number of questions for Student " + (i + 1));
            }
            int correct = checkAnswer(answers[i], key);
            System.out.printf("Student %d had %d correct answer(s)\n", i + 1, correct);
        }
    }

    private static int checkAnswer(String answer, String key) {
        int correct = 0;
        for (int i = 0; i < 4; i++) {
            if (answer.charAt(i) == key.charAt(i)) {
                correct++;
            }
        }
        return correct;
    }
}
