class Solution {
    //Time O(N^3)
    //space O(1)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  
        for(int i = 0 ; i < nums.length ; i++)
        {
            //Skip same numbers
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1 ; j < nums.length ; j++)
            {
                //Skip same numbers
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int low = j+1 , high = nums.length-1;
                while(low < high)
                {
                    int sum = nums[low] + nums[high] + nums[i] + nums[j];
                    if(sum == target)
                    {
                        result.add(Arrays.asList(nums[i] , nums[j] , nums[low] , nums[high]));
                        low++;
                        high--;
                    }
                    else if(sum < target)
                    {
                        low++;
                    }
                    else
                    {
                        high--;
                    }
                    while(low > j+1 && low < nums.length && nums[low] == nums[low-1]) low++;
                    while(high >= 0 && high < nums.length-1 && nums[high] == nums[high+1]) high--;
                }
            }
        }
        return result;
    }
}