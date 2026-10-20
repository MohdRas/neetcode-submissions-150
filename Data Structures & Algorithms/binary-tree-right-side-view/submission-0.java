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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); // null is delimiter

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr == null) {

                if(!queue.isEmpty()) queue.offer(null); // null is delimiter
            }else{
                if(queue.peek() == null) {
                    // if next element is delimiter
                    list.add(curr.val);
                }
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            
            

        }

        return list;

        
    }
}
