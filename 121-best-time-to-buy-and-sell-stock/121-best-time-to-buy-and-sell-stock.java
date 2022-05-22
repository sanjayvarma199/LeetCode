class Solution {
    //Time O(N)
    //Space O(1)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
        {
            return 0;
        }
        int min = prices[0] , ans = 0;
        for(int i = 1 ; i < prices.length ; i++)
        {
            ans = Math.max(prices[i] - min , ans);
            min = Math.min(min , prices[i]);
        }
        return ans;
    }
}