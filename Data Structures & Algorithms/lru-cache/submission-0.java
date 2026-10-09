class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);

        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);

        this.head.next = this.tail;
        this.tail.prev = this.head;

    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);

        if(node != null){
            node.val = value;
            moveToHead(node);
        }else{
            if(map.size() >= capacity){
                Node lru = removeTail();
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
        }
    }

    // helpers
    private void addToHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail(){
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}
