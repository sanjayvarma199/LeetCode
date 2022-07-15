class MyHashMap {
    //Time O(1) Amortized
    //Space O(1)
    class Node
    {
        int key , val;
        Node next;
        public Node(int key , int val)
        {
            this.key = key;
            this.val = val;
            next = null;
        }
    }
    Node nodes[];
    int bucketSize = 1001;
    public MyHashMap() {
        nodes = new Node[bucketSize];
    }
    
    private int Index(int key)
    {
        return Integer.hashCode(key) % bucketSize;
    }
    
    private Node Find(Node head , int key)
    {
        Node curr = head , prev = null;
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = Index(key);
        if(nodes[index] == null)
        {
            nodes[index] = new Node(-1,-1);
        }
        Node head = Find(nodes[index] , key);
        if(head.next == null)
        {
            head.next = new Node(key , value);
        }
        else
        {
            head.next.val = value;
        }
    }
    
    public int get(int key) {
        int index = Index(key);
        if(nodes[index] == null)
        {
            return -1;
        }
        Node head = Find(nodes[index] , key);
        if(head.next == null)
        {
            return -1;
        }
        return head.next.val;
    }
    
    public void remove(int key) {
        int index = Index(key);
        if(nodes[index] == null) return;
        Node head = Find(nodes[index] , key);
        if(head.next != null)
        {
            head.next = head.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */