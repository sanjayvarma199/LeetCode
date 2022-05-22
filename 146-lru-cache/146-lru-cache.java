class LRUCache {
    //Time O(1)
    //Space O(capacity)
    class Node
    {
        Node prev , next;
        int key , val;
        public Node(int key , int val)
        {
            prev = null ; next = null;
            this.key = key;
            this.val = val;
        }
    }
    
    Node LRU_list , dummy_end;
    int capacity;
    
    HashMap<Integer , Node> map;
    public LRUCache(int capacity) {
        LRU_list = new Node(-1,-1);
        dummy_end = new Node(-1,-1);
        LRU_list.next = dummy_end;
        dummy_end.prev = LRU_list;
        
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node temp = map.get(key);
        
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
            
        AddtoHead(temp);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key) && capacity == 0)
        {
            Node remove = dummy_end.prev;
            removeFromLast(remove);
            map.remove(remove.key , remove);
            capacity++;
        }
        //Limt not exceeded
        if(map.containsKey(key))
        {
            Node temp = map.get(key);
            temp.val = value;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev; 
            AddtoHead(temp);
        }
        else
        {
            Node temp = new Node(key,value);
            AddtoHead(temp);
            map.put(key , temp);
            capacity--;
        }
    }
    
    private void removeFromLast(Node node)
    {
        dummy_end.prev.prev.next = dummy_end;
        dummy_end.prev = dummy_end.prev.prev;
    }
    private void AddtoHead(Node temp)
    {
        temp.next = LRU_list.next;
        LRU_list.next.prev = temp;
        LRU_list.next = temp;
        temp.prev = LRU_list;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */