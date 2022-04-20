class KthLargest {
    //Time O(Nlogk)
    //Space O(K)
    PriorityQueue<Integer> PQ;
    int k;
    public KthLargest(int k, int[] nums) {
        PQ = new PriorityQueue<>();
        this.k = k;
        for(int i : nums)
        {
            PQ.add(i);
            if(PQ.size() > k) PQ.poll();
        }
    }
    
    public int add(int val) {
        PQ.add(val);
        if(PQ.size() > k) PQ.poll();
        return PQ.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */