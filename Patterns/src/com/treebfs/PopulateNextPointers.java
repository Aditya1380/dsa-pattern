package com.treebfs;

import java.util.LinkedList;
import java.util.Queue;

//Problem specific Node definition
class Node {
 public int val;
 public Node left;
 public Node right;
 public Node next;

 public Node(int _val) { val = _val; }
}

public class PopulateNextPointers {

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Your Trusted BFS Engine
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                // CRITICAL CHECK: If this is NOT the last node of the current layer,
                // the next node right neighbor is currently waiting at the front of our line!
                if (i < levelSize - 1) {
                    currentNode.next = queue.peek();
                }

                // Append children for the next wave
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        // Constructing a perfect binary tree layer:
        //       1
        //      / \
        //     2   3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        Node connectedRoot = connect(root);
        
        // Verifying level 1 horizontal wire:
        System.out.println("Node 2's next points to: " + connectedRoot.left.next.val); // Expected: 3
        System.out.println("Node 3's next points to: " + (connectedRoot.right.next == null ? "NULL" : "NODE")); // Expected: NULL
    }
    
}