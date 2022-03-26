class Solution {
    //Time O(N)
    //Space O(N)
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int max_len = 0 , rSum = 0;
        // Create a map to maintain the rSum and intial position
        Map<Integer , Integer> map = new HashMap<>();
        
        //Edge Case
        map.put(0 , -1);
        for(int i = 0 ; i < nums.length ; i++)
        {
            rSum += (nums[i] == 0) ? -1 : 1;
            if(map.containsKey(rSum))
            {
                max_len = Math.max(max_len , i - map.get(rSum));
            }
            else
            {
                map.put(rSum , i);
            }
        }
        return max_len;
    }
}