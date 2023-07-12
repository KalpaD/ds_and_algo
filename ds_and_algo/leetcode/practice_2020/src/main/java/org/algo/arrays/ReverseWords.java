package org.algo.arrays;

public class ReverseWords {

    public String reverse(String s) {
        String[] workds = s.split(" ");
        int len = workds.length;
        for (int i = 0; i < (len / 2); i++) {
            String temp = workds[i];
            workds[i] = workds[len - 1 - i];
            workds[len - 1 - i] = temp;
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < workds.length; i++) {
            sb.append(workds[i]);
            if (i != workds.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseUsingCharArray(String s) {
        char[] charArray = s.toCharArray();
        char [] result = new char[s.length()];
        int source = s.length() - 1;
        int dst = 0;
        while (source >= 0) {
            if (charArray[source] == ' ') {
                result[dst++] = charArray[source--];
            }
            else {
                int wordEnd = source;
                while (source >= 0 && charArray[source] != ' ') {
                    source--;
                }

                int worReadPos = source + 1;

                while (worReadPos <= wordEnd) {
                    result[dst++] = charArray[worReadPos++];
                }
            }

        }

        return new String(result);
    }
}
