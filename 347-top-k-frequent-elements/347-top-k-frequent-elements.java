class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return nums;
        }
        
        List<Integer> ar[] = new List[nums.length+1];
        
        List<Integer> ans = new ArrayList<>();
        
        //To maintain the freq
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i : nums)
        {
            map.put(i , map.getOrDefault(i , 0)+1);
        }
        
        //Allocate all the numbers to their respective freq
        for(Integer i : map.keySet())
        {
            int index = map.get(i);
            if(ar[index] == null)
            {
                ar[index] = new ArrayList<>();
            }
            ar[index].add(i);
        }
        
        for(int i = nums.length ; i >= 0 ; i--)
        {
            if(ar[i] == null) continue;
            for(int j : ar[i])
            {
                ans.add(j);
                k--;
                if(k == 0)
                {
                    return ans.stream().mapToInt(l -> l).toArray();
                }
            }
        }
        return nums;
    }
}