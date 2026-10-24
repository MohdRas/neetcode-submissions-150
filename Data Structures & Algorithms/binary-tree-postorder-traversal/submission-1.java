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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){

            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode peekRight = stack.peek().right;
                if(peekRight == null){
                    TreeNode lastPopped= stack.pop();
                    list.add(lastPopped.val);
                    while(!stack.isEmpty() && lastPopped == stack.peek().right){
                        lastPopped = stack.pop();
                        list.add(lastPopped.val);
                    }
                }else{
                    curr = peekRight;
                }
            }
        }

        return list;
    }
}