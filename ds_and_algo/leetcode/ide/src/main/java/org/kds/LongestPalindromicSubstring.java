package org.kds;

import java.util.*;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        if (s.equals("")) {
            return "";
        }

        // build the character map
        Map<Character, List<Integer>> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            if (charMap.containsKey(currentChar)) {
                if (charMap.get(currentChar) == null) {
                    List<Integer> indices = new ArrayList<Integer>();
                    indices.add(i);
                    charMap.put(currentChar, indices);
                } else {
                    List<Integer> indices = charMap.get(currentChar);
                    indices.add(i);
                }
            } else {
                List<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                charMap.put(currentChar, indices);
            }
        }

        Map<Integer, Integer[]> distanceIndexArrayMap = new HashMap<>();

        Iterator<Map.Entry<Character, List<Integer>>> iterator = charMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, List<Integer>> entry = iterator.next();
            List<Integer> indices = entry.getValue();
            if (indices.size() >= 2) {

                for (int i = 0; i + 1 < indices.size(); i++) {
                    int start = indices.get(i);
                    int end = indices.get(i + 1);

                    int distance = end - start;
                    Integer[] disArray = new Integer[2];
                    disArray[0] = start;
                    disArray[1] = end;
                    distanceIndexArrayMap.put(distance, disArray);
                }
            } else if (indices.size() == 1) {
                int start = indices.get(0);
                int end = indices.get(0);
                int distance = end - start;
                Integer[] disArray = new Integer[2];
                disArray[0] = start;
                disArray[1] = end;
                distanceIndexArrayMap.put(distance, disArray);
            }
        }

        int maxDistance = 0;
        String maxPalindrome = "";

        Iterator<Map.Entry<Integer, Integer[]>> disiterator = distanceIndexArrayMap.entrySet().iterator();
        while (disiterator.hasNext()) {
            Map.Entry<Integer, Integer[]> entry = disiterator.next();
            if (maxDistance < entry.getKey()) {
                // we found long word lets see its palindromeness
                Integer[] value = entry.getValue();
                //int modifyValue = value[1] < s.length() ? value[1] + 1 ?
                String substring = s.substring(value[0], value[1] + 1);
                boolean  isPalindrome = isPalindrome(substring);
                if (isPalindrome) {
                    maxDistance = entry.getKey();
                    maxPalindrome = substring;
                } else {
                    maxDistance = 0;
                }
            }
        }

        boolean isAllUniqueCase = true;

        // coould be all chars are unique then just return the first char
        Iterator<Map.Entry<Character, List<Integer>>> charMapIterator = charMap.entrySet().iterator();
        if (charMapIterator.hasNext()) {
            Map.Entry<Character, List<Integer>> next = charMapIterator.next();
            if (next.getValue().size() != 1) {
                isAllUniqueCase = false;
            }
        }


        if (maxDistance == 0 && isAllUniqueCase) {
            return Character.toString(s.charAt(0));
        }

        return maxPalindrome;
    }

    private boolean isPalindrome(String input) {

        char [] chars = input.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2;  i++) {
            if (! (chars[i] == chars[len - i -1])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String [] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        //System.out.println(lps.longestPalindrome("abctacocatde"));
        System.out.println(lps.longestPalindrome("cbbd"));
        System.out.println(lps.longestPalindrome("abcdcba"));
        System.out.println(lps.longestPalindrome("ac"));
        System.out.println(lps.longestPalindrome("bb"));

    }
}
