class Solution {
    //Time O(logN)
    //Space O(1)
    public int getSum(int a, int b) {
        int x = Math.abs(a) , y = Math.abs(b);
        if(x < y)
        {
            return getSum(b , a);
        }
        int sign = 1;
        
        //Check the sign
        if(a < 0)
        {
            sign =  -1;
        }
        
        if(a*b >= 0)
        {
            while(y != 0)
            {
                int answer = x ^ y;
                int carry = (x & y) << 1;
                x = answer;
                y = carry;
            }
        }
        else
        {
            while(y != 0)
            {
                int answer = x ^ y;
                int borrow = (~x & y) << 1;
                x = answer;
                y = borrow;
            }
        }
        return x*sign;
    }
}