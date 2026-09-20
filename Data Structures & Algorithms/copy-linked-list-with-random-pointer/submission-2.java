/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
public Node copyRandomList(Node head) {
    if (head == null) return null;
    
    // ==========================================
    // PHASE 1: The Neighbor Blueprint (Interweaving)
    // ==========================================
    Node curr = head;
    while (curr != null) {
        Node clone = new Node(curr.val);          // 1. Create a fresh copy of the current node
        clone.next = curr.next;                   // 2. Point clone to the rest of the original list
        curr.next = clone;                        // 3. Insert the clone right after the current original node
        curr = clone.next;                        // 4. Move curr forward to the next original node
    }
    
    // ==========================================
    // PHASE 2: Setting the Secret Paths (Random Pointers)
    // ==========================================
    curr = head;
    while (curr != null) {
        if (curr.random != null) {
            // Cloned random points to the target clone, which lives right next 
            // to the original target node (curr.random.next)
            curr.next.random = curr.random.next;  
            
            // Note: curr.next.random = curr.random; would be incorrect because 
            // it makes the clone point back into the old, original list (violating deep copy rules)
        }
        curr = curr.next.next;                    // Jump two steps forward to reach the next original node
    }
    
    // ==========================================
    // PHASE 3: The Great Separation (Untangling)
    // ==========================================
    curr = head;
    Node cloneHead = head.next;                   // Save the starting head of our deep-copied list
    while (curr != null) {
        Node clone = curr.next;                   // Isolate the clone node
        curr.next = clone.next;                   // Reconnect original node to the next original node (skipping clone)
        
        if (clone.next != null) {
            clone.next = clone.next.next;         // Connect clone node to the next clone node (skipping original)
        }
        curr = curr.next;                         // Move curr forward to the next original node
    }
    
    return cloneHead;                             // Return the independent deep-copied list
}
}
