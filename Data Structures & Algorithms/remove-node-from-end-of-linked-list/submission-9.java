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
        
        ListNode curr = head;

        int num = n;

        ListNode first = head;
        ListNode second = head;
        
        while(num >0){
            second = second.next;
            num--;
        }

        while(second != null && second.next != null){

            second = second.next;
            first = first.next;

        }

        if(first.next != null && second != null){
            first.next = first.next.next;
            return curr;
        }else if(first.next != null && second == null){
            return first.next;
        }else{
            return null;
        }

        
        
    }
}
