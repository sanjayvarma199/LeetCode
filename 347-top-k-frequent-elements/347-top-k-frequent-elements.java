class Solution {
    //Time O(N + Nlogk)
    //Space O(N + K)
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0)
        {
            return nums;
        }
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
        }
        
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a , b) -> (map.get(a) - map.get(b)));
        for(int i : map.keySet())
        {
            PQ.add(i);
            if(PQ.size() > k)
            {
                PQ.poll();
            }
        }
        int ans[] = new int[k];
        int i = k;
        while(!PQ.isEmpty())
        {
            ans[--i] = PQ.poll();
        }
        return ans;
    }
}