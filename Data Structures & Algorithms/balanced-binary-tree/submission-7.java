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
    public boolean isBalanced(TreeNode root) {
        return height(root)[0] == 1;
        
    }
    public int[] height(TreeNode root){

        if(root == null) return new int[]{1,0};

        int[] leftHeight = height(root.left);
        int[] rightHeight = height(root.right);
        
        int currIsbalanced = 0; 
        if(Math.abs(leftHeight[1] - rightHeight[1]) <= 1 && leftHeight[0] == 1 && rightHeight[0] == 1 ){
           currIsbalanced = 1;
        }
        int currHeight = 1 + Math.max(leftHeight[1],rightHeight[1]);
        return new int[]{currIsbalanced,currHeight};
    }
}
