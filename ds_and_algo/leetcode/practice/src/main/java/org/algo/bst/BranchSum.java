package org.algo.bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.stream.StreamSupport;

/**
 * Write a function that takes ina binary tree and retunrs a list of its branch sus orders from leftmost branch sum
 * to right most branch sum
 *
 * A branch sum is a suma of all values in abinray tree branch
 * A binary tree branch is a path of nodes ina a tree that starts at the root node and ends at any
 * leaf node.
 *        1
 *      2        3
 *   4    5   6   7
 * 8   9 10
 * Example
 * [15, 16, 18, 10, 11]
 * // 15 => 1 + 2 + 4 + 8
 * 16 => 1 + 2 + 4 + 9
 */

public class BranchSum {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", BinaryTree.class.getSimpleName() + "[", "]")
                    .add("value=" + value)
                    .toString();
        }
    }

    public static List<Integer> branchSum(BinaryTree root) {

        Stack<BinaryTree> nodeStack = new Stack<>();
        nodeStack.add(root);
        Map<Integer, Integer> branchSumMap = new HashMap<>();
        branchSumMap.put(root.value, root.value);
        List<Integer> branchSumList = new ArrayList<>();

        while (!nodeStack.empty()) {
            BinaryTree node = nodeStack.pop();
            System.out.println("current node " + node.value);

            if (node.right != null) {
                branchSumMap.put(node.right.value, branchSumMap.get(node.value) + node.right.value);
                nodeStack.push(node.right);
            }

            if (node.left != null) {
                branchSumMap.put(node.left.value, branchSumMap.get(node.value) + node.left.value);
                nodeStack.push(node.left);
            }

            if (node.left == null && node.right == null) {
                int branchSum = branchSumMap.get(node.value);
                System.out.println("node : " + node.value + "branchSum : "+ branchSum);
                branchSumList.add(branchSum);
            }
        }

        return branchSumList;
    }

    public static void main(String[] args) {
        BinaryTree _10 = new BinaryTree(10, null, null);
        BinaryTree _9 = new BinaryTree(9, null, null);
        BinaryTree _8 = new BinaryTree(8, null, null);
        BinaryTree _4 = new BinaryTree(4, _8, _9);
        BinaryTree _5 = new BinaryTree(5, _10, null);
        BinaryTree _6 = new BinaryTree(6, null, null);
        BinaryTree _7 = new BinaryTree(7, null, null);
        BinaryTree _2 = new BinaryTree(2,_4 , _5);
        BinaryTree _3 = new BinaryTree(3, _6, _7);
        BinaryTree _1 = new BinaryTree(1, _2, _3);

        List<Integer> integers = branchSum(_1);
        System.out.println(integers);
    }
}
