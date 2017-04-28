package com.example.jatin.myapplication;

/**
 * Created by JATIN on 29-04-2017.
 */

public class Text {
    private static final String[] letters = {
            "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
    };

    private static char getChar(int digit, int count) {
        while (count > letters[digit].length()) {
            count -= letters[digit].length();
        }

        return letters[digit].charAt(count - 1);
    }

    public static String getString(CharSequence input) {
        int lastDigit = 0, count = 1;
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = input.charAt(i) - '0';
            if (currentDigit >= 2 && currentDigit <= 9) {
                if (lastDigit == 0) {
                    lastDigit = currentDigit;
                } else if (currentDigit == lastDigit) {
                    count++;
                } else {
                    result += getChar(lastDigit, count);

                    lastDigit = currentDigit;
                    count = 1;
                }
            }
        }

        return result + getChar(lastDigit, count);
    }
}
