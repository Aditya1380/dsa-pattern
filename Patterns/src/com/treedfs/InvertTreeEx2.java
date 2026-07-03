package com.treedfs;

public class InvertTreeEx2 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		// Constructing a sample tree:
        //       4
        //      / \
        //     2   7
        //    / \ / \
        //   1  3 6  9
		System.out.print("Original In-Order: ");
		printInOrder(root); // Output: 1 2 3 4 6 7 9
		System.out.println();

		root = invertTree(root);

		System.out.print("Inverted In-Order: ");
		printInOrder(root);
	}

	private static TreeNode invertTree(TreeNode root) {
		if(root==null) {
			return null;
		}

		TreeNode leftInverted = invertTree(root.left);
		TreeNode rightInverted = invertTree(root.right);
		
		root.left = rightInverted;
		root.right = leftInverted;
		
		return root;
	}

	public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}
