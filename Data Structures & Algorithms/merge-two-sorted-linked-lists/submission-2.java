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

            // As long as both are not null ( pointing to a node)

            if(list1.val <= list2.val){
               curr.next = list1; 
               list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            
            // move dummy to keep next element
            curr = curr.next;
        }

        // any one list will be remaing out of both lists

        if(list1 != null){
            // remaining list1
            curr.next = list1;
        }
        if(list2 != null){
            // remaining list2
            curr.next = list2;
        }

        return dummy.next;
        
    }
}