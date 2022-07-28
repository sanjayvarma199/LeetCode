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
            int j = i+1 , k = nums.length-1;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while(j < k)
            {
                int sum = nums[j] + nums[k];
                if(nums[i] == -sum)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                    //To avoid duplicates
                    while(j < k && nums[j-1] == nums[j]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
                else if(nums[i] < -sum)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        return result;
    }
}