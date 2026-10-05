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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // this would be the new head
        ListNode curr = head;

        while(curr != null){ // i need to each every single node inn the list

            ListNode temp = curr.next; // keeping a pointer to the next node

            curr.next = prev; // new next would be prev

            prev =  curr; // prev would sit at curr

            curr = temp; // curr would be next of the prrevious curr

        }
        System.out.println(curr);
        return prev;
    }
}
