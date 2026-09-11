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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // we need dummy behind the head
        ListNode dummy = new ListNode(0, head);

        ListNode curr = dummy;

        // length from start
        int totalLength = 0;

        while(curr.next != null){ // excluding "dummy" from count
            curr = curr.next;
            totalLength++; 
        }

        int nodeFromStart = totalLength - n; 
        // nodeFromStart = 2 => means 2nd node from start

        curr = dummy; 
        while(nodeFromStart > 0){
            curr = curr.next;
            nodeFromStart--;
        }
        // curr is node just behind the node to be deleted
        curr.next = curr.next.next;

        return dummy.next;

    }
}
