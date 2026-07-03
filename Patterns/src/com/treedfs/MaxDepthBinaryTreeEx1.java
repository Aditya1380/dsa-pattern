package com.treedfs;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

}
public class MaxDepthBinaryTreeEx1 {

    public static int maxDepth(TreeNode root) {
        // We call a helper function so we can pass an "indent" string to style our logs
        return maxDepthVisualizer(root, "");
    }

    private static int maxDepthVisualizer(TreeNode root, String indent) {
        // 1. Log whenever we ENTER a function call
        if (root == null) {
            System.out.println(indent + "➜ Entered: null | Base Case reached! Returning 0");
            return 0;
        }
        System.out.println(indent + "➜ Entered Node [" + root.val + "] -> Asking kids for their depths...");

        // Increase the indentation for the children so they look nested under this parent
        String childIndent = indent + "    ";

        // 2. Dive Left
        System.out.println(childIndent + "Checking LEFT child of [" + root.val + "]:");
        int leftDepth = maxDepthVisualizer(root.left, childIndent);

        // 3. Dive Right
        System.out.println(childIndent + "Checking RIGHT child of [" + root.val + "]:");
        int rightDepth = maxDepthVisualizer(root.right, childIndent);

        // 4. Calculate current result
        int currentResult = 1 + Math.max(leftDepth, rightDepth);

        // 5. Log right before we EXIT and hand the answer back up to the parent (Backtracking)
        System.out.println(indent + "⇠ Backtracking out of Node [" + root.val + "] | Left=" + leftDepth 
                           + ", Right=" + rightDepth + " | Deepest side + 1 = Returning " + currentResult);

        return currentResult;
    }

    public static void main(String[] args) {
        // Constructing the sample tree:
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("=== STARTING DFS TRAVERSAL ===\n");
        int totalDepth = maxDepth(root);
        System.out.println("\n=== TRAVERSAL FINISHED ===");
        System.out.println("Final Maximum Depth: " + totalDepth);
    }
}
//public class MaxDepthBinaryTree {
//	public static void main(String[] args) {
//		// Constructing a sample tree:
//		//  3
//		// / \
//		//   9 20
//		//  / \
//		// 15 7
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(9);
//		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15);
//		root.right.right = new TreeNode(7);
//
//		System.out.println("Maximum Depth of the Tree: " + maxDepth(root)); // Output: 3
//	}
//
//	private static int maxDepth(TreeNode root) {
//		if (root == null) {
//			return 0;
//		}
//
//		int leftDepth = maxDepth(root.left);
//		int rightDepth = maxDepth(root.right);
//
//		return 1 + Math.max(leftDepth, rightDepth);
//	}
//}
