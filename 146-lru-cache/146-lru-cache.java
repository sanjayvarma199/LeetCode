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
    Map<Integer , Node> map;
    Node head , tail;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addToHead(Node node)
    {
        node.next =  head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node curr = map.get(key);
        remove(curr);
        addToHead(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0 && !map.containsKey(key))
        {
            Node curr = tail.prev;
            remove(curr);
            map.remove(curr.key , curr);
            capacity++;
        }
        Node curr;
        if(map.containsKey(key))
        {
            curr = map.get(key);
            curr.val = value;
            remove(curr);
        }
        else
        {
            curr = new Node(key , value);
            map.put(key , curr);
            capacity--;
        }
        addToHead(curr);
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */