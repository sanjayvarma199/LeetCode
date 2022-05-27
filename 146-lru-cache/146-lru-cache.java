class LRUCache {
    class Node
    {
        Node prev , next;
        int key , val;
        public Node(int key , int val)
        {
            this.key = key;
            this.val = val;
            prev = null; next = null;
        }
    }
    
    Node head , tail;
    Map<Integer , Node> map;
    int capacity;
    public LRUCache(int capacity) {
        head =  new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node;
        if(map.containsKey(key))
        {
            node = map.get(key);
            remove(node);
            addToHead(node);
        }
        else
        {
             return -1;
        }
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node;
        if(!map.containsKey(key) && capacity == 0)
        {
            Node temp = tail.prev;
            remove(temp);
            map.remove(temp.key , temp);
            capacity++;
        }
        if(map.containsKey(key))
        {
            node = map.get(key);
            node.val = value;
            remove(node);
        }
        else
        {
            node = new Node(key , value);
            capacity--;
            map.put(key , node);
        }
        addToHead(node);
    }
    
    private void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addToHead(Node node)
    {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */