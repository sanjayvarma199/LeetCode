class Solution {
    //Time O(NlogNlogM)
    //Space O(N)
    public int minimumDeviation(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        //Max Heap
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a,b) -> (b-a));
        int min = Integer.MAX_VALUE;
        for(int i : nums)
        {
            if(i % 2 != 0)
            {
                i = i*2;
            }
            min = Math.min(min , i);
            PQ.add(i);
        }
        int diff = Integer.MAX_VALUE;
        while((PQ.peek() % 2 == 0))
        {
            int poll = PQ.poll();
            diff = Math.min(diff , poll - min);
            min = Math.min(min , poll/2);
            PQ.add(poll/2);
        }
        return Math.min(diff , PQ.poll() - min);
    }
}