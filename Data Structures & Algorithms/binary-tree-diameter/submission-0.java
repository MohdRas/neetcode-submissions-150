/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       maxDiameter = 0; // Reset for safety across multiple calls
        calculateHeight(root);
        return maxDiameter; 
    }
    private int calculateHeight(TreeNode node) {
        // Base case: a null node has a height of -1 (in terms of edges)
        if (node == null) {
            return -1;
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Calculate the diameter passing through the current node.
        // Because null returns -1, if a child is null, its contribution is (leftHeight + 1).
        // Let's trace how edge-based heights interact with diameter:
        // Diameter through node = (leftHeight + 1) + (rightHeight + 1)
        int currentDiameter = (leftHeight + 1) + (rightHeight + 1);

        // Update the global maximum diameter
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        // Return the height of the current node to its parent
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
