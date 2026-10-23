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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int max = root.val; // 2
        int left = goodN(root.left, max); // 1,2
        int right = goodN(root.right, max); // 1 2
        System.out.println(left + " " + right);
        return 1 + left + right;
    }

    private int goodN(TreeNode root, int max){ // 1 2
        if(root == null) return 0; 
        if(root.val >= max){ // 1 2
            max = root.val;
            return 1 + goodN(root.left, max) + goodN(root.right, max); 
        }else{
            return goodN(root.left, max) + goodN(root.right, max); // 1 1 + 5 2
        }
             
    }
}
