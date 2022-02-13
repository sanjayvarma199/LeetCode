class Solution {
    //Time O(N^2)
    //Space O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        
        //Sort the Array
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++)
        {
            int low = i + 1 , high = nums.length-1;
            
            //Skip the numbers which are equal
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while(low < high)
            {
                int sum = nums[low] + nums[high];
                if(sum == -nums[i])
                {
                    result.add(Arrays.asList(nums[i] , nums[low] , nums[high]));
                    low++;
                    high--;
                }
                else if(sum < -nums[i])
                {
                    low++;
                }
                else
                {
                    high--;
                }
                //Skip the numbers which are equal
                while(i != low-1 && low < nums.length && nums[low] == nums[low-1]) low++;
                while(high >= 0 && high < nums.length-1 && nums[high] == nums[high+1]) high--;
            }
        }
        return result;
    }
}