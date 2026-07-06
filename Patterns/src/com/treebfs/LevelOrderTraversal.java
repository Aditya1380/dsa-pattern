package com.treebfs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Base Case: If the tree is empty, return an empty list
        if (root == null) {
            return result;
        }

        // Create our FIFO line (Queue) and invite the CEO (root) to step in
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Keep going as long as there is someone waiting in line
        while (!queue.isEmpty()) {
            // Step 1: Count exactly how many people belong to this specific level
            int levelSize = queue.size();
            List<Integer> currentLevelData = new ArrayList<>();

            // Step 2: Process ONLY the nodes belonging to this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Pull the front person out of line
                currentLevelData.add(currentNode.val); // Record their value

                // Step 3: Send their direct children to the back of the line for the next round
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Once the sub-loop finishes, the current level is completely cleared!
            result.add(currentLevelData);
        }

        return result;
    }

    public static void main(String[] args) {
        // Constructing our sample tree:
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

        System.out.println("Level Order Traversal: " + levelOrder(root));
        // Expected Output: [[3], [9, 20], [15, 7]]
    }
}
