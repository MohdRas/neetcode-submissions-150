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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) 
            return;

        // find mid
        // reverse mid to end ( second half)
        // merge first half & sorted second half


        // find mid
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }
        // slow is the mid
        // prevSlow is before slow
        prevSlow.next = null;
        

        // reverse mid to end
        ListNode curr = slow;
        ListNode prev= null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // prev would be head of the reverse list
        // curr would be null
        ListNode list2 = prev;
        ListNode list1 = head;

        // merge these 2 lists
        ListNode dummy =  new ListNode(0);
        while(list1 != null && list2 != null){

            dummy.next = list1;
            list1 = list1.next;
            dummy = dummy.next;

            dummy.next = list2;
            list2 = list2.next;
            dummy = dummy.next;

        }

        dummy.next = (list1 != null) ? list1 : list2;

        head = dummy.next;
        
    }
}
