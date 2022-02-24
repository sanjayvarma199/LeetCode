class Solution {
    //Time O(N)
    //Space O(N)
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int sum = 0 , ans = 0;
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1); // Edge Case
        for(int i = 0 ; i < nums.length ; i++)
        {
            sum += nums[i];
            if(map.containsKey(sum - goal))
            {
                ans += map.get(sum-goal);
            }
            map.put(sum , map.getOrDefault(sum , 0)+1);
        }
        return ans;
    }
}