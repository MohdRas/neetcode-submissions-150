class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0, head);

        int totalLength = 0;
        ListNode curr = head;
        while(curr != null){
            totalLength++;
            curr = curr.next;
        }

        int iterations = totalLength / k;
        if (iterations == 0) return head;

        curr = head;
        ListNode prevGroupTail = dummy;

        while(iterations > 0) {
            ListNode groupStart = curr;
            ListNode prev = null;
            
            // Reverse the k nodes for the current group
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect the newly reversed group back to the main list
            prevGroupTail.next = prev; // 'prev' is now the new head of this reversed group
            groupStart.next = curr;    // 'groupStart' is now the tail of this group, connect it to the remaining list
            
            prevGroupTail = groupStart; // Move tail pointer for the next iteration
            iterations--;
        }

        return dummy.next;
    }
}