class Solution {
    //Time O(N)
    //Space O(N)
    public int subarraySum(int[] nums, int k) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int count = 0 , rSum = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1); //Edge case
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            rSum += nums[i];
            if(map.containsKey(rSum - k))
            {
                count += map.get(rSum - k);
            }
            map.put(rSum , map.getOrDefault(rSum , 0)+1);
        }
        return count;
    }
}