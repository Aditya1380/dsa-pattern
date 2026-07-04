package com.treedfs;

public class ValidateBST {
	public static void main(String[] args) {
        // Constructing our trap tree example:
        //     6
        //    / \
        //   1   5
        //      / \
        //     4   3
        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(1);
        invalidRoot.right = new TreeNode(6);
        invalidRoot.right.left = new TreeNode(3);
        invalidRoot.right.right = new TreeNode(4);

        System.out.println("Is trap tree a valid BST? " + isValidBST(invalidRoot)); // Output: false

        // Constructing our trap tree example:
        //     5
        //    / \
        //   2   7
        //      / \
        //     8   6
        TreeNode validRoot1 = new TreeNode(5);
        validRoot1.left = new TreeNode(2);
        validRoot1.right = new TreeNode(7);
        validRoot1.right.left = new TreeNode(6);
        validRoot1.right.right = new TreeNode(8);

        System.out.println("Is tree 1 a valid BST? " + isValidBST(validRoot1)); // Output: true
    }

	public static boolean isValidBST(TreeNode root) {
        // Start the DFS sweep with true infinity boundaries (null)
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Long minAllowed, Long maxAllowed) {
        // Base Case 1: An empty node or running off a leaf path is completely valid
        if (node == null) {
            return true;
        }

        // Base Case 2: Check if the current value breaks the lower bound restriction
        if (minAllowed != null && node.val <= minAllowed) {
            return false;
        }

        // Base Case 3: Check if the current value breaks the upper bound restriction
        if (maxAllowed != null && node.val >= maxAllowed) {
            return false;
        }

        // Recursive Step: Go Left (update max bound) AND Go Right (update min bound)
        // BOTH subtrees must be completely valid for the whole tree to count as a BST
        return validate(node.left, minAllowed, (long) node.val) && 
               validate(node.right, (long) node.val, maxAllowed);
    }
}
