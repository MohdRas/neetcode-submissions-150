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

        // fast will reach behind the node "to be deleted"
        while(n>0){
            fast = fast.next;
            n--;
        }

        // slow & fast are separated by "n"
        System.out.println("slow "  + slow.val);
        System.out.println("fast "  + fast.val);

        // slow & fast will move at the same speed
        // fast will go till "last element"
        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
            System.out.println("loop slow "  + slow.val);
            System.out.println("loop fast "  + fast.val);
        }
        
        // slow is the node behind "the node to be deleted"
        // if "head" is the node to be deleted then we have "dummy" node behind it.
        slow.next = slow.next.next;

        // dummy.next would always be "head of the list"
        return dummy.next;

    }
}
