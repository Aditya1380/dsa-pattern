package com.treedfs;

public class BinaryTreeMaximumPathSumEx9 {

    public static void main(String[] args) {
        // Constructing LeetCode's classic negative-root test tree:
        //       -10
        //       /  \
        //      9    20
        //          /  \
        //         15   7
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Path Sum: " + maxPathSum(root)); 
        // Expected Output: 42 (The path is 15 -> 20 -> 7)
    }

    private static int globalMax;

    private static int maxPathSum(TreeNode root) {        
        globalMax = Integer.MIN_VALUE;
        calculateGain(root);
        return globalMax;
    }

    private static int calculateGain(TreeNode root) {
        if(root==null){
            return 0;            
        }

        int leftGain = Math.max(0, calculateGain(root.left));
        int rightGain = Math.max(0,calculateGain(root.right));

        int currentArchPrice = root.val + leftGain + rightGain;

        globalMax = Math.max(globalMax, currentArchPrice);

        return root.val + Math.max(leftGain, rightGain);        
    }
}
