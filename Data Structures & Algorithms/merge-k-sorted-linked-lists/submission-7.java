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

        // min priority queue (list1-list2)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((list1,list2)-> list1.val-list2.val);

        for(ListNode list : lists){
            
            // ListNode[] lists = [[]]
            // first list inside the array is [] ( empty list, means null)
            if(list != null){   
                pq.offer(list);
            }
        }

        while(pq.size() !=0){ 
            
            ListNode smallest = pq.poll(); 

            // form final list
            curr.next = smallest;
            curr = curr.next;

            // if smallest has any "next" element then add to the priority queue
            if(smallest.next != null){
                pq.offer(smallest.next);
            }
        }
        
        // dummy'next is a "head" of the final list
        return dummy.next;
    }
}
