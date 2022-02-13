class Solution {
    //Time O(N^2)
    //Space O(N)
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        //Input Validation
        if(nums1 == null || nums2 == null || nums3 == null || nums4 == null)
        {
            return 0;
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums1.length ; i++)
        {
            for(int j = 0 ; j < nums2.length ; j++)
            {
                int sum = nums1[i] + nums2[j];
                map.put(sum , map.getOrDefault(sum , 0)+1);
            }
        }
        int result = 0;
        for(int i = 0 ; i < nums1.length ; i++)
        {
            for(int j = 0 ; j < nums2.length ; j++)
            {
                int sum = nums3[i] + nums4[j];
                if(map.containsKey(-sum))
                {
                    result += map.get(-sum);
                }
            }
        }
        return result;
    }
}