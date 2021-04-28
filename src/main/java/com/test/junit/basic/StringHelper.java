package com.test.junit.basic;

public class StringHelper {

    public String truncateAInFirstTwoPosition(String str) {
        if (str.length() <= 2) {
            return str.replaceAll("A", "");
        }

        String firstTwoChars = str.substring(0, 2);
        String stringMinusFirstTwoChars = str.substring(2);

        return firstTwoChars.replaceAll("A", "") + stringMinusFirstTwoChars;
    }

    public boolean areFirstAndLastTwoCharactersTheSame(String str) {

        if (str.length() <= 1)
            return false;
        if (str.length() == 2)
            return true;

        String first2Chars = str.substring(0, 2);

        String last2Chars = str.substring(str.length() - 2);

        return first2Chars.equals(last2Chars);
    }

}
