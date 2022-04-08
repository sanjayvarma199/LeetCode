class KthLargest {
    //Time O(NlogK) N --> add calls
    //Space O(K)
    PriorityQueue<Integer> PQ;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        PQ = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            PQ.add(nums[i]);
            if(PQ.size() > k)
            {
                PQ.poll();
            }
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