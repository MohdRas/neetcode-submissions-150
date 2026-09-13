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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // dummy
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(list1 != null && list2 != null){
            // as long as both has nodes

            if(list1.val <= list2.val){
               curr.next = list1; 
               list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            // move dummy to next
            curr = curr.next;
        }

        if(list1 != null){
            // list1 remaining
            curr.next = list1;
        }
        if(list2 != null){
            // list2 remaining
            curr.next = list2;
        }

        return dummy.next;
        
    }
}