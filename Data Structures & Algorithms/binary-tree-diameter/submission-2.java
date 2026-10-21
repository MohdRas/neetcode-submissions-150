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
    
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root){

        if(root == null) return 0; // height in terms of "no of nodes"
        
        int leftHeight = height(root.left); // height of left subtree
        int rightHeight = height(root.right); // height of right subtree

        // leftHeight + rightHeight = diameter at a node
        diameter =  Math.max(diameter, leftHeight + rightHeight); 

        // return height
        return 1 + Math.max(leftHeight, rightHeight);

    }
}
