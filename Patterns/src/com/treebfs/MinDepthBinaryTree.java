package com.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBinaryTree {
	public static void main(String[] args) {
        // Constructing our unbalanced test tree:
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9); // Leaf Node! (Depth 2)
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Minimum Depth of the Tree: " + minDepth(root)); 
        // Expected Output: 2 (Because node 9 is a leaf sitting right on level 2)
    }

	private static int minDepth(TreeNode root) {
		
		int depth = 1;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			int levelSize = queue.size();
			
			for(int i=0;i<levelSize;i++) {
				if(currentNode.left == null && currentNode.right == null) {
					return depth;
				}
				
				if(currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
			
			depth++;
		}
		
		return depth;
	}
}
