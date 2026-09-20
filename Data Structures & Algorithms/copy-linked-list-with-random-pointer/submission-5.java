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

        if(head == null ) return head;

        // intereaving

        Node curr = head;
        while(curr != null){
            Node clone = new Node(curr.val);
            clone.next = curr.next;

            curr.next = clone;
            curr = clone.next;

        }

        // random pointer update
        curr = head;
        while(curr != null){
            Node clone = curr.next;
            if(curr.random != null){
                clone.random = curr.random.next; //curr.random is the original node
            }
            curr = curr.next.next;
        }

        // separation of list
        curr = head;
        Node cloneHead = curr.next;
        while(curr != null){
            Node clone = curr.next;
            curr.next = clone.next;
            if(clone.next != null){ // here clone.next is the next original element
                // if no next element then its next ( which is clone will also be not present)
                clone.next = clone.next.next;
            }
            curr = curr.next;
        }

        return cloneHead;

    }
}
