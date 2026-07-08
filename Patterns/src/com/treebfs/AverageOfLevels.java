package com.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
	public static void main(String[] args) {
        // Constructing our test tree:
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(25);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Averages of each level: " + averageOfLevels(root));
        // Expected Output: [3.0, 14.5, 11.0]
        // Level 0: 3 / 1 = 3.0
        // Level 1: (9 + 20) / 2 = 14.5
        // Level 2: (15 + 7) / 2 = 11.0
    }

	private static List<Double> averageOfLevels(TreeNode root) {
		List<Double> averages = new ArrayList<Double>();
		
		if(root==null) {
			return averages;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			
			double levelSum = 0;
			
			for(int i=0;i<levelSize;i++) {
				TreeNode currentNode = queue.poll();
				
				levelSum += currentNode.val;
				
				if(currentNode.left!=null) {
					queue.add(currentNode.left);
				}
				if(currentNode.right!=null) {
					queue.add(currentNode.right);
				}
			}
			
			double average = levelSum/levelSize;
			averages.add(average);
		}
		
		return averages;
	}
}
