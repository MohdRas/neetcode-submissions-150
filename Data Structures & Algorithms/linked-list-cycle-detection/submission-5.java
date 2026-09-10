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
    public boolean hasCycle(ListNode head) {
        // HASHSET
        Set<ListNode> seen = new HashSet<>();

        ListNode curr = head;
        while(curr != null){ // VISIT EACH NODE ONCE
            
            if(seen.contains(curr)) return true; // CHECK IF ALREADY VISITED

            seen.add(curr); // ADD TO HASHSET 

            curr = curr.next; // MOVE NEXT

        }

        return false;
        
    }
}
