/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode headTemp = head;

        ListNode prevLeft = null;

        ListNode leftNode = head;
        int start = left;

        while(leftNode!=null && start > 1){
            prevLeft = leftNode;
            leftNode = leftNode.next;
            start--;
        }

        ListNode prev = null;
        ListNode curr = leftNode;

        while(curr != null && left <= right){
            
                ListNode temp = curr.next;
                curr.next = prev;

                prev = curr;
                curr = temp;

                left++;
        }

        leftNode.next = curr;
        if(prevLeft != null){
            prevLeft.next = prev;
            return headTemp;
        }else{
            return prev;
        }

    }
}