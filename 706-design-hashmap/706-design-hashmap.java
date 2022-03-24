class MyHashMap {
    //Time amortized O(1)
    //Space O(10000)
    class Node
    {
        int key , val;
        Node next;
        public Node(int key , int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    Node nodes[];
    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    private int Index(int key)
    {
        return Integer.hashCode(key) % nodes.length;
    }
    
    private Node Find(Node head , int key)
    {
        Node prev = null , curr = head;
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
            nodes[index] = new Node(-1 , -1);
        }
            Node find = Find(nodes[index] , key);
            if(find.next == null)
            {
                //No key is present in the map create the new one
                find.next = new Node(key , value);
            }
            else
            {
                //Replace the value
                find.next.val = value;
            }
    }
    
    public int get(int key) {
        int index = Index(key);
        if(nodes[index] == null)
        {
            return -1;
        }
        Node find = Find(nodes[index] , key);
        if(find.next == null)
        {
            return -1;
        }
        else
        {
            return find.next.val;
        }
    }
    
    public void remove(int key) {
        int index = Index(key);
        if(nodes[index] == null) return;
        Node find = Find(nodes[index] , key);
        if(find.next == null) return;
        find.next = find.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */