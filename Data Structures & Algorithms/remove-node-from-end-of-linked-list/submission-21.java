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
        // Dummy node behind the "head" node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(n>0){
            fast = fast.next;
            n--;
        }

        System.out.println("slow"  + slow.val);
        System.out.println("fast"  + fast.val);

        while(fast != null && fast.next != null){
            // we want fast to stay at the last element
            fast = fast.next;
            slow = slow.next;
            System.out.println("loop slow"  + slow.val);
            System.out.println("loop fast"  + fast.val);
        }
        

        slow.next = slow.next.next;

        return dummy.next;

    }
}
