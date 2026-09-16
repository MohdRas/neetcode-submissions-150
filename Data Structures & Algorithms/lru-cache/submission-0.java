class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {

        map = new HashMap<>(capacity);
        this.capacity = capacity;

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail; // head -> tail
        tail.prev = head; // tail -> head
        
    }
    
    public int get(int key) {

        if(!map.containsKey(key)) return -1;

        // If value of the map is not a "node" then first find "node" in the DDL and then do posistion adjustments
        Node node = map.get(key); 
       
        removeFromCurrentPosition(node);
        insertIntoFront(node);       

        return node.val; // Node must have a "val" field to keep the value    
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){

            Node node = map.get(key);
            node.val = value; // updating node's value

            removeFromCurrentPosition(node);
            insertIntoFront(node);    

        }else{

            if(map.size() == capacity){
                // hashmap full
                // remove least recently used
                // least recently would be at "tail.prev" because recently used are moved towards "head"
                Node lru = tail.prev;
                removeFromCurrentPosition(lru);
                map.remove(lru.key);

            }

            Node node =  new Node(key,value);
            map.put(key, node);
            insertIntoFront(node);       

        }
        
    }

    void removeFromCurrentPosition(Node node){
        // node.prev <-> node <-> node.next

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    void insertIntoFront(Node node){

        // head <-> new node <-> head.next

        node.next = head.next; // node's next
        node.prev = head; // node's prev

        head.next.prev = node; // head.next's prev
        head.next = node; // head's next

    }

}
