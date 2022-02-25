class Solution {
    //Time O(N)
    //Space O(N)
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        return Atmost(nums , k) - Atmost(nums , k-1);
    }
    
    private int Atmost(int[] nums , int k)
    {
        if(k < 0) return 0;
        // Maintains Freq map
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int left = 0 , result = 0;
        
        for(int right = 0 ; right < nums.length ; right++)
        {
            int num = nums[right];
            map.put(num , map.getOrDefault(num , 0) + 1);
            
            while(map.size() > k)
            {
                int left_num = nums[left];
                map.put(left_num , map.get(left_num) - 1);
                map.remove(left_num , 0);
                left++;
            }
            result += right-left+1;
        }
        return result;
    }
}