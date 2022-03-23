public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        //if(n < 0) n = -n;
        while(n != 0)
        {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}