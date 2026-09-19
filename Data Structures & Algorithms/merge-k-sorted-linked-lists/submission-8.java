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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0); // new head
        ListNode curr = dummy;

        // min heap (list1-list2)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((list1,list2)-> list1.val-list2.val);

        for(ListNode list : lists){
            
            // lists = [[]]
            // first list inside the array is "[]" ( empty list, means null)
            if(list != null){   
                pq.offer(list);
            }
        }

        while(pq.size() !=0){ 
            
            ListNode minElement = pq.poll(); // polling the min element

            // final list
            curr.next = minElement;
            curr = curr.next;

            // if minElement has any "next" element then add it to the min heap
            if(minElement.next != null){
                pq.offer(minElement.next);
            }
        }

        // dummy.next = head of the final list
        return dummy.next;
    }
}
