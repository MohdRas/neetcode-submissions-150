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


public class Solution {
    public boolean hasCycle(ListNode head) {
       // SLOW FAST POINTER

        ListNode curr = head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next; // move by 1 position
            fast = fast.next.next; // move by 2 position

            if(slow == fast) // BOTH POINTING TO THE SAME NODE
                return true;

        }
        return false;
    }
}