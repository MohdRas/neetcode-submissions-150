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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null) return false;
        //if(subRoot == null) return true;
        if(root.val == subRoot.val && isSame(root,subRoot)){
            System.out.println(root.val + " equal ");
            return true;
        }
        System.out.println(root.val + " equal " + subRoot.val);
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subroot){

        if(root == null && subroot == null) return true;
        if(root == null || subroot == null) return false;
        System.out.println(root.val + " isSame " + subroot.val);
        if(root.val != subroot.val) return false;
        return isSame(root.left, subroot.left) && isSame(root.right, subroot.right);
    }
}
