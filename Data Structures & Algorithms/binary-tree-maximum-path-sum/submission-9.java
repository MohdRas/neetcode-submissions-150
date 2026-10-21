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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        pathSum(root);
        return maxSum;
        
    }

    public int pathSum(TreeNode root){
        if(root == null) return 0; // this is path sum of null node

        int leftMax = Math.max(0, pathSum(root.left));
        int rightMax = Math.max(0, pathSum(root.right));

        //pathsum of current node = root.val + leftMax + rightMax
        maxSum = Math.max(maxSum, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);

    }
}
