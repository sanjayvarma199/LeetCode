class Solution {
    //Time O(N)
    //Space O(N)
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int[][] DP = new int[nums.length+1][2];
        for(int i = 1 ; i < DP.length ; i++)
        {
            DP[i][0] = Math.max(DP[i-1][0] , DP[i-1][1]);
            DP[i][1] = DP[i-1][0] + nums[i-1];
        }
        int ans = Math.max(DP[DP.length-1][0] , DP[DP.length-1][1]);
        
        return ans;
    }
}