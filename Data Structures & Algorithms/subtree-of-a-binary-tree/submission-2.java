class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        // If values match, verify if the entire subtrees are identical
        if (root.val == subRoot.val) {
            if (isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right)) {
                return true;
            }
        }
        
        // Otherwise, continue searching down the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode root, TreeNode subRoot) {
        // Fixed null checks
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        
        if (root.val != subRoot.val) return false;
        
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}