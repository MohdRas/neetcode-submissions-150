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

        // Dummy Node points to head
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;

        // length from start
        int totalLength = 0;

        while(curr.next != null){
            curr = curr.next;
            totalLength++;
        }

        int nodeFromStart = totalLength - n; // this is length not index

        curr = dummy; // we need a dummy node to keep at prev of the head
        while(nodeFromStart > 0){ // reaching to the prev of the node to delete
            curr = curr.next;
            nodeFromStart--;
        }

        curr.next = curr.next.next;

        return dummy.next;

    }
}
