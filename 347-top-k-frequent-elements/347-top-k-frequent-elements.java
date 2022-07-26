class Solution {
    //Time O(N)
    //Space O(N)
    public int[] topKFrequent(int[] nums, int k) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return nums;
        }
        Map<Integer , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }
        
        List<Integer> ar[] = new List[nums.length + 1];
        
        for(int ele : map.keySet())
        {
            int freq = map.get(ele);
            if(ar[freq] == null) 
            {
                ar[freq] = new ArrayList<>();
            }
            ar[freq].add(ele);
        }
        
        int ans[] = new int[k];
        int j = 0;
        for(int i = nums.length ; i >= 0 ; i--)
        {
            if(ar[i] == null) continue;
            for(int ele : ar[i])
            {
                ans[j] = ele;
                j++;
                k--;
                if(k == 0) return ans;
            }
        }
        return ans;
    }
}