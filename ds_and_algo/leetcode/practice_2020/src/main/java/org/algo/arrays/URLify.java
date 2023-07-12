package org.algo.arrays;

public class URLify {

    public String urLify(String s, int trueLength) {

        char [] chars = s.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }

        int newIndexForLastChar = (trueLength - 1) +  2 * spaceCount;

        for (int j = trueLength - 1; j >= 0; j--) {

            if (chars[j] == ' ') {
                chars[newIndexForLastChar] = '0';
                chars[newIndexForLastChar - 1] = '2';
                chars[newIndexForLastChar - 2] = '%';
                newIndexForLastChar = newIndexForLastChar - 3;
            } else {
                 chars [newIndexForLastChar] = chars[j];
                 newIndexForLastChar--;
            }
        }

        return new String(chars);
    }

    public String urLify2(String s, int trueLength) {

        char [] res = new char[s.length()];
        char [] chars = s.toCharArray();

        for (int i = 0, j = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                res[j] = '%';
                res[j + 1] = '2';
                res[j + 2] = '0';
                j = j + 3;
            }
            else {
                res[j++] = chars[i];
            }
        }

        return new String(res);
    }
}
