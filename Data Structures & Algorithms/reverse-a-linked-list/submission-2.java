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

        while(curr != null){

            ListNode temp = curr.next;

            curr.next = prev;
            prev =  curr;
            curr = temp;

        }
        System.out.println(curr);
        return prev;
    }
}
