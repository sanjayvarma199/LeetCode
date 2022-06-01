class LRUCache {

    class Node
    {
        Node prev , next;
        int key , val;
        public Node(int key , int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    Node head , tail;
    int capacity;
    Map<Integer , Node> map;
    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node;
        if(!map.containsKey(key) && capacity == 0)
        {
            node = tail.prev;
            map.remove(node.key , node);
            removeNode(node);
            capacity++;
        }
        if(map.containsKey(key))
        {
            node = map.get(key);
            node.val = value;
            removeNode(node);
        }
        else
        {
            node = new Node(key , value);
            map.put(key , node);
            capacity--;
        }
        addToHead(node);
    }
    
    private void addToHead(Node node)
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */