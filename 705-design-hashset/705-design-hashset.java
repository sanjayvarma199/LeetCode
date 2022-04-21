class MyHashSet {
    //Time O(1)
    //Space O(N)

    int buckets = 1001 , bucketList = 1001;
    boolean set[][];
    public MyHashSet() {
        set = new boolean[buckets][];
    }
    
    private int getBucket(int key)
    {
        return key%buckets;
    }
    
    private int getBucketItem(int key)
    {
        return key / bucketList;
    }
    
    public void add(int key) {
        int i = getBucket(key) , j = getBucketItem(key);
        if(set[i] == null)
        {
            set[i] = new boolean[bucketList];
        }
        set[i][j] = true;
    }
    
    public void remove(int key) {
        int i = getBucket(key) , j = getBucketItem(key);
        if(set[i] == null)
        {
            return;
        }
        set[i][j] = false;
    }
    
    public boolean contains(int key) {
        int i = getBucket(key) , j = getBucketItem(key);
        if(set[i] == null)
        {
            return false;
        }
        return set[i][j];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */