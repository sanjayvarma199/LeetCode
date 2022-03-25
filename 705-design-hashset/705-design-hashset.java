class MyHashSet {
    //Time O(N)
    //Space O(1)
    private int buckets , bucketItems;
    boolean Storage[][];
    public MyHashSet() {
        buckets = 1001;
        bucketItems = 1001;
        Storage = new boolean[buckets][];
    }
    
    private int bucket(int key)
    {
        return key % buckets;
    }
    
    private int bucketItem(int key)
    {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        if(Storage[bucket] == null)
        {
            Storage[bucket] = new boolean[bucketItems];
        }
        int bucketItem = bucketItem(key);
        Storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        if(Storage[bucket] == null)
        {
            return;
        }
        int bucketItem = bucketItem(key);
        Storage[bucket][bucketItem] = false;
        return;
    }
    
    public boolean contains(int key) {
        int bucket = bucket(key);
        if(Storage[bucket] == null)
        {
            return false;
        }
        int bucketItem = bucketItem(key);
        return Storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */