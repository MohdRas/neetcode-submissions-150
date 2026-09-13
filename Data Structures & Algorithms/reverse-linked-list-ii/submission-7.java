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

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy; // dummy is the new head

        ListNode prevLeft = null;
        for(int i=0; i<left; i++){
            prevLeft = curr;
            curr = curr.next;
        }

        ListNode leftNode = prevLeft.next;

        // curr is the "left" node and will go till "right" node

        ListNode prev = null;
        while( curr != null && left <= right){

            ListNode temp =  curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;

            left++;
        }

        leftNode.next = curr;
        prevLeft.next = prev;

        return dummy.next;
        
    }
}