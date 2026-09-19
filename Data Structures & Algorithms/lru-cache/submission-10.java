class LRUCache {
    int capacity;
    Map<Integer, Node> map;
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
         this.capacity = capacity;
         map = new HashMap<>();
         head = new Node(0,0);
         tail = new Node(0,0);
         head.next = tail;
         tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);

        //re-postion because "node" got accessed (get operation)
        remove(node);
        insertAtHead(node);

        return node.val;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;

            //re-postion because "node" got accessed (get operation)
            remove(node);
            insertAtHead(node);
        }else{

            if(map.size() == capacity){
                Node lru = tail.prev; // prev to tail node
                remove(lru); 
                map.remove(lru.key); 
            }
            
            Node newNode = new Node(key, value);
            map.put(key,newNode);

            insertAtHead(newNode);
        }
        
    }

    public void remove(Node node){

        // node.prev <-------> node <-------> node.next
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    public void insertAtHead(Node node){
        // head   <--------> head.next
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}
