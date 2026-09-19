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

        // min priority queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>((list1,list2)-> list1.val-list2.val);

        for(ListNode list : lists){
            if(list != null){
                pq.offer(list); // 1 1 3
            }
        }

        while(pq.size() !=0){ // 1, 1, 3 2 3 4
            
            ListNode smallest = pq.poll(); // 2

            // form final list
            curr.next = smallest; // 2
            curr = curr.next; // 2

            // if smallest has any "next" element then add to the priority queue
            if(smallest.next != null){ // 2-> 4
                pq.offer(smallest.next); // 4
            }
        }
        // dummy'next is a "head" of the final list
        return dummy.next;
    }
}
