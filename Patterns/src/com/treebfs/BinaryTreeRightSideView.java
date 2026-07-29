package com.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public static void main(String[] args) {
        // Constructing our sample tree:
        //       1         <-- Level Size 1: Rightmost is [1]
        //      / \
        //     2   3       <-- Level Size 2: Rightmost is [3]
        //      \   \
        //       5   4     <-- Level Size 2: Rightmost is [4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println("Right Side View: " + rightSideView(root)); 
        // Expected Output: [1, 3, 4]
    }

	private static List<Integer> rightSideView(TreeNode root) {
		List<Integer> visibleNodes = new ArrayList<Integer>();
		
		if(root == null) {
			return visibleNodes;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			
			for(int i=0;i<levelSize;i++) {
				
				TreeNode currentNode = queue.poll();
				
				if(i == levelSize - 1) {
					visibleNodes.add(currentNode.val);
				}
				
				if(currentNode.left != null) {
					queue.add(currentNode.left);
				}
				
				if(currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
			
		}
		
		return visibleNodes;
	}
}
