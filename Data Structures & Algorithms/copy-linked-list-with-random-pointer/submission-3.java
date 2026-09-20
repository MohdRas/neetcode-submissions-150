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

        Map<Node, Node> map =  new HashMap<>();
        
        Node curr = head;
        while(curr != null){

            Node clone = new Node(curr.val);
            map.put(curr, clone); // <original, clone> without links

            curr = curr.next;

        }

        curr = head; // curr at head
        while(curr != null){ // create links
            Node clone = map.get(curr);
            clone.next = map.get(curr.next);
            if(curr.random != null){
                clone.random = map.get(curr.random);
            }

            curr = curr.next;
        }

        return map.get(head);
        
    }
}
