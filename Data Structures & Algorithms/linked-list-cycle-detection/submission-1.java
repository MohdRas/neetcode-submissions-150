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
    public boolean hasCycle(ListNode head) {

        // starting at the same position(head)
        // moving in the same direction, fast pointer twice as fast as slow pointer.
        // once reaches at the same position (slow == fast) -> cycle exists
        // if not then no cycle.

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){ 
            // first & second element exists - first iteration and subsequent iteratrions.
            slow = slow.next; // second element
            fast = fast.next.next; // next of second element. If second element does not exist - then null pointer
            if(slow == fast) return true;

        }

        return false;
    }
}
