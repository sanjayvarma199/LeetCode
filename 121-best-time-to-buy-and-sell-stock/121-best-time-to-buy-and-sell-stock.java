class Solution {
    //Time O(N)
    //Space O(1)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
        {
            return 0;
        }
        
        int min = Integer.MAX_VALUE , max = 0;
        for(int i = 0 ; i < prices.length ; i++)
        {
            if(prices[i] <  min)
            {
                min = prices[i];
            }
            else if(prices[i] - min > max)
            {
                max = prices[i]-min;
            }
        }
        return max;
    }
}