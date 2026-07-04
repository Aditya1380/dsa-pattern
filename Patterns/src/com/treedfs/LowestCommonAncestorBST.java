package com.treedfs;

public class LowestCommonAncestorBST {
	public static void main(String[] args) {
		// Constructing our valid test tree:
        //          6
        //        /   \
        //       2     8
        //      / \   / \
        //     0   4 7   9
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		TreeNode p = root.left.left; // Node 0
		TreeNode q = root.left.right; // Node 4		
		
		TreeNode lca = lowestCommonAncestor(root, p, q);
		System.out.println("LCA of 0 and 4 is: " + lca.val); // Expected Output: 2
		
		TreeNode p1 = root.right.left; // Node 7
		TreeNode q1 = root.right.right; // Node 9
		
		TreeNode lca1 = lowestCommonAncestor(root, p1, q1);
		System.out.println("LCA of 7 and 9 is: " + lca1.val); // Expected Output: 2
	}

	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left,p,q);
		}

		if(p.val > root.val && q.val>root.val) {
			return lowestCommonAncestor(root.right,p,q);
		}
		return root;
	}
}
