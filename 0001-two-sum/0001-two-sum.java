class Solution {
    //TC O(N)
    //SC O(N)
    public int[] twoSum(int[] nums, int target) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return new int[]{-1,-1};
        }
        //To Maintain the compliement of the target
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            int compliment = target-nums[i];
            if(map.containsKey(compliment))
            {
                return new int[] {map.get(compliment) , i};
            }
            map.put(nums[i] , i);
        }
        return new int[] {-1,-1};
    }
}