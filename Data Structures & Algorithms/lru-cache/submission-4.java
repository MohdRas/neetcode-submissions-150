class LRUCache {

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

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {

        // store capacity
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);

        // dummy "head" and "tail"
        head = new Node(0, 0);
        tail = new Node(0, 0);

        // link "head" and "tail"
        head.next = tail;
        tail.prev = head;  
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);

        // re-position
        remove(node);
        insertAtHead(node);
        return node.val;
        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){

            Node node = map.get(key);
            node.val = value; // update value
            
            // re-position
            remove(node);
            insertAtHead(node);

        }else{
            if(map.size() == capacity){
                Node lru = tail.prev;
                remove(lru); // remove LRU from DDL
                map.remove(lru.key); // remove LRU from map via key
            }
            Node node = new Node(key,value);
            insertAtHead(node); // insert new node at head
            map.put(key, node); // put new node in map
        }
        
    }

    void remove(Node node){
        // node.prev  <===> node   <====> node.next
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    void insertAtHead(Node node){
        //head <=====> head.next

        // first fix node's own pointer first
        node.next = head.next; 
        node.prev = head;      

        head.next.prev = node; // prev of "next of node"
        head.next = node;      
    }
}
