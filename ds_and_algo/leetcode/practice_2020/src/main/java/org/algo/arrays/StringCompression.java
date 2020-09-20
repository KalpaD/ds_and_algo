package org.algo.arrays;

public class StringCompression {

    public String compress(String s) {

       StringBuilder sb = new StringBuilder();
       char currentChar = ' ';
       int count = 0;
       for (char c : s.toCharArray()) {

           if (currentChar == ' ') {
               currentChar = c;
               count++;
           }
           else if (currentChar == c) {
               count++;
           }
           else {
               sb.append(currentChar);
               sb.append(count);
               currentChar = c;
               count = 0;
               count++;
           }
       }

        if (count > 0) {
            sb.append(currentChar);
            sb.append(count);
        }

       if (sb.toString().length() < s.length()) {
           return sb.toString();
       }
       else {
           return s;
       }
    }


}
