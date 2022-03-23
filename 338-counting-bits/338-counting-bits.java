class Solution {
    //Time O(NlogN)
    //Space O(1)
    public int[] countBits(int n) {
        int[] ar = new int[n+1];
        for(int i = 0 ; i <= n ; i++)
        {
            ar[i] = count(i);
        }
        return ar;
    }
    private int count(int n)
    {
        int count = 0;
        while(n != 0)
        {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}