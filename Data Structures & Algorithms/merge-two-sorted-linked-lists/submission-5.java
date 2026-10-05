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

        if(list1 == null && list2 == null) return null;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;


        while(list1 != null && list2 != null){

            if(list1.val <= list2.val){
                curr.next = list1; // next of curr node

                list1 = list1.next; // list1 will point to list1.next
               
            }else{
                curr.next = list2; // curr's next would be list2
                list2 = list2.next; // list2 will move further
            }

             curr = curr.next; // move curr further


        }
        // above loop will continue as long as both having some elements
        // curr would be the last of the nodes

        if(list1 == null){
            curr.next = list2;
        }else{
            curr.next = list1;
        }
        
        return dummy.next;
    }
}