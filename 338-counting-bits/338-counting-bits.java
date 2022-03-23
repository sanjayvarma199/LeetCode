class Solution {
    //Time O(N)
    //Space O(1)
    public int[] countBits(int n) {
        int[] ar = new int[n+1];
        for(int i = 1 ; i <= n ; i++)
        {
            ar[i] = ar[i & (i-1)] + 1;
        }
        return ar;
    }
}