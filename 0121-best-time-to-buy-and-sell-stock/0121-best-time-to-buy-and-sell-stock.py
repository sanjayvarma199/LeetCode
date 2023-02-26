class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if False:
            [sellday, buyday, work] = self.nsquare_time_constant_space(prices)
        if True:
            [sellday, buyday, work] = self.nlogn_time_logn_space(prices)
        if False:
            [sellday, buyday, work] = self.ntime_constant_space(prices)
        p = self._compute_profit(prices, sellday, buyday)
        return p

    #############################################
    # All public function here. 
    #############################################

    ########################################
    # TIME:THETA(N^2)
    # Space:THETA(1)
    # CANNOT CHANGE ANYTHING BELOW
    #########################################
    def nsquare_time_constant_space(self, a: List[int]) -> "[sellday,buyday,work]":
        return self._nsquare_time_constant_space(a) 


    ########################################
    # TIME:THETA(NlogN)
    # Space:THETA(logn)
    # CANNOT CHANGE ANYTHING BELOW
    #########################################
    def nlogn_time_logn_space(self, a: List[int]) -> "[sellday,buyday,work]":
        return self._nlogn_time_logn_space(a)

    ########################################
    # TIME:THETA(N)
    # Space:THETA(1)
    # CANNOT CHANGE ANYTHING BELOW
    #########################################
    def ntime_constant_space(self, a: List[int]) -> "[sellday,buyday,work]":
        return self._ntime_constant_space(a)
        

    #############################################
    # All private function here. 
    # WRIYE CODE BELOW
    
    def _nsquare_time_constant_space(self, prices):
        ans = 0
   
        next = [0,0,0]
        work = 0
        for i in range(len(prices)):
            for j in range(i,len(prices)):
                work += 1
                if prices[j] - prices[i] > ans:
                    ans = prices[j] - prices[i]
                    next[0] = j
                    next[1] = i
                    
                    
        next[2] = work
        return next
    
    def _nlogn_time_logn_space(self,prices):
        a = self.helper(prices, 0, len(prices)-1)
        
        return [a[2], a[1], 1]
    
    def helper(self,A, start, stop):
        n = stop - start

        if n == 0:
            return 0, start, start

        if n == 1:
            return A[stop] - A[start], start, stop

        mid = int(start + n/2)

        max_profit1, buy1, sell1 = self.helper(A, start, mid-1)
        max_profit2, buy2, sell2 = self.helper(A, mid, stop)

        mp_buy_idx = start
        mp_buy_val = A[start]
        for k in range(start+1, mid):
            if A[k] < mp_buy_val:
                mp_buy_val = A[k]
                mp_buy_idx = k

        mp_sell_idx = mid
        mp_sell_val = A[mid]
        for k in range(mid+1, stop+1):
            if A[k] > mp_sell_val:
                mp_sell_val = A[k]
                mp_sell_idx = k

        max_profit_cross_border = mp_sell_val - mp_buy_val

        if max_profit2 > max_profit1:
            if max_profit_cross_border > max_profit2:
                return max_profit_cross_border, mp_buy_idx, mp_sell_idx
            else:
                return max_profit2, buy2, sell2
        else:
            if max_profit_cross_border > max_profit1:
                return max_profit_cross_border, mp_buy_idx, mp_sell_idx
            else:
                return max_profit1, buy1, sell1
    

    def _ntime_constant_space(self,prices):
        left = 0 #Buy
        right = 1 #Sell
        max_profit = 0
        buyDay = 0
        sellDay = 0
        work = 0
        while right < len(prices):
            currentProfit = prices[right] - prices[left] #current Profit
            if prices[left] < prices[right]:
                if(currentProfit > max_profit):
                    buyDay = right
                    sellDay = left
                max_profit =max(currentProfit,max_profit)
            else:
                left = right
            right += 1
            work += 1
        return [buyDay,sellDay,work]
    
    # You can have any number of private functions and variables
    # NOTHING CAN BE CHABGED BELOW
    #############################################
    def _compute_profit(self, a: List[int], s: "int", b: "int") -> "int":
        n = len(a)
        if n == 0:
            return 0
        assert s >= 0 and s < n
        assert b >= 0 and b < n
        assert s >= b
        p = a[s] - a[b]
        if p < 0:
            return 0;
        return p