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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();

        if(root == null) return finalList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); // delimiter


        while(!queue.isEmpty()){
            
            TreeNode curr = queue.poll();
            
            if(curr == null){
                finalList.add(list);
                list = new ArrayList<>();

                if(!queue.isEmpty()) queue.offer(null); // delimiter
            }else{
                list.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right !=null) queue.offer(curr.right);
            }

        }

        return finalList;
        
    }
}
