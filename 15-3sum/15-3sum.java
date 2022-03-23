class Solution {
    //Time O(N^2)
    //Space O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return new ArrayList<>();
        }
        
        //Sort the input array
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            int low = i+1 , high = nums.length-1;
            //Skip the duplicates
            if(i > 0 && nums[i] == nums[i-1]) continue;

            //Two pointers to find -ve sum
            while(low < high)
            {
                int sum = nums[low] + nums[high];
                if(nums[i] == -sum)
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[low]) ; list.add(nums[high]);
                    result.add(list);
                    low++;high--;
                    while(low < high && nums[low] == nums[low-1]) low++;
                    while(low < high && nums[high] == nums[high+1]) high--;
                }
                else if(nums[i] < -sum)
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