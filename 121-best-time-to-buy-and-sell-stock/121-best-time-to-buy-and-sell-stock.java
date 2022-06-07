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
            if(prices[i] < min)
            {
                min = prices[i];
            }
            else
            {
                ans = Math.max(Math.abs(prices[i]-min) , ans);
            }
        }
        return ans;
    }
}