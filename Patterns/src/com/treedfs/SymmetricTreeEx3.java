package com.treedfs;

public class SymmetricTreeEx3 {
	public static void main(String[] args) {
		// Constructing a perfectly symmetric sample tree:
		//     1
		//    / \
		//   2   2
		//  / \ / \
		// 3  4 4  3
		TreeNode symmetricRoot = new TreeNode(1);
		symmetricRoot.left = new TreeNode(2);
		symmetricRoot.right = new TreeNode(2);
		symmetricRoot.left.left = new TreeNode(3);
		symmetricRoot.left.right = new TreeNode(4);
		symmetricRoot.right.left = new TreeNode(4);
		symmetricRoot.right.right = new TreeNode(3);

		System.out.println("Is tree 1 symmetric? " + isSymmetric(symmetricRoot)); // Output: true
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isMirror(root.left, root.right);
	}

	private static boolean isMirror(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		if (node1.val != node2.val) {
			return false;
		}
		return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
	}
}
