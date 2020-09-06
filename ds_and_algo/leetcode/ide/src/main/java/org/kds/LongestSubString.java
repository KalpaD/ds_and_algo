package org.kds;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        int len  = s.length();
        int result = 0;
        int lowerBound = 0, upperBound = 0;
        Set<Character> set = new HashSet<>();

        while (lowerBound < len && upperBound < len) {
            if (!set.contains(s.charAt(upperBound))) {
                set.add(s.charAt(upperBound++));
                result  = (result < upperBound - lowerBound) ? (upperBound - lowerBound) : result;
            } else {
                set.remove(s.charAt(lowerBound));
                lowerBound++;
            }
        }
        return result;
    }



    public static void main(String [] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        LongestSubString  ls = new LongestSubString();
        System.out.println("abcabcbb : "+ ls.lengthOfLongestSubstring(s1));
        System.out.println("bbbbb : "+ ls.lengthOfLongestSubstring(s2));
        System.out.println("pwwkew : "+ ls.lengthOfLongestSubstring(s3));
    }
}
