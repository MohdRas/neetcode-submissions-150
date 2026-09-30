class LRUCache {
    
    int capacity;
    Map<Integer, Node> map;
    Node head; // sentinel head
    Node tail; // sentinel tail

    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }


    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        
        map = new HashMap<>(capacity);

        head = new Node(0, 0);
        tail = new Node(0, 0);
        
        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        addToHead(node);

        return node.value;
        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value; 

            remove(node);
            addToHead(node);

        }else{

            if(capacity == map.size()){
                Node lru = tail.prev;
                remove(lru); // remove from the DDL
                map.remove(lru.key); // remove from the MAP
            }
            Node node = new Node(key, value);
            addToHead(node);
            map.put(key, node);
            

        }
        
    }
    public void remove(Node node){
       // node.prev <-> node <-> node.next
       node.prev.next = node.next; 
       node.next.prev = node.prev;

    }

    public void addToHead(Node node){
        // head <-> node <-> head.next 

        //first node
        node.next = head.next;
        node.prev = head;

        // neighbours
        head.next.prev = node;
        head.next = node;

    }
}
