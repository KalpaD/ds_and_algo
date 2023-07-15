package org.algo.recursion;

// Write a function that takes in an array of unique integers and returns an array of all permutations of those
// integers in no particular order.
// If the input array is empty, the function should return and empty array

import java.util.ArrayList;
import java.util.List;

// array = [1, 2, 3]
// sample output = [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
public class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        System.out.println(current);
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Found a valid permutation
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (current.contains(nums[i])) {
                    continue; // Skip if the number is already chosen
                }
                current.add(nums[i]); // Choose the number
                backtrack(nums, current, result); // Recurse with the updated choice
                current.remove(current.size() - 1); // Undo the choice for backtracking
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = findPermutations(nums);
        for (List<Integer> permutation : permutations) {
            //System.out.println(permutation);
        }
    }
}
