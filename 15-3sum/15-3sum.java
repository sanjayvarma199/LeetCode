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
        
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length-2 ; i++)
        {
            //Two pointer approach to find the -nums[i]
            int low = i+1 , high = nums.length-1;
            
            //Skip the adjacent elements which are equal to avoid duplicates
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while(low < high)
            {
                int sum = nums[low] + nums[high];
                if(sum == -nums[i])
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);list.add(nums[low]);list.add(nums[high]);
                    result.add(list);
                    low++;high--;
                    while(low < high && nums[low] == nums[low-1]) low++;
                    while(low < high && nums[high] == nums[high+1]) high--;
                }
                else if(sum < -nums[i])
                {
                    low++;
                }
                else
                {
                    high--;
                }
            }
        }
        return result;
    }
}