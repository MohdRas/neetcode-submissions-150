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
        
        // dummy is the new head
        ListNode dummy = new ListNode(0, head); 
        
        ListNode curr = dummy; 

        ListNode prevLeft = null; // "node just before left"
        for(int i=0; i<left; i++){
            prevLeft = curr;
            curr = curr.next;
        }

        ListNode leftNode = prevLeft.next; // "node at left" 

        ListNode prev = null;
        while( curr != null && left <= right){

            ListNode temp =  curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;

            left++;
        }

        leftNode.next = curr; // "node at left" will point to "curr" node
        prevLeft.next = prev; // "node just before left" will point to "prev"

        return dummy.next;
        
    }
}