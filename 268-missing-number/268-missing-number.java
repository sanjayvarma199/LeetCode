class Solution {
    //Time O(N)
    //Space O(1)
    public int missingNumber(int[] nums) {
        int num = nums.length;
        for(int i = 0 ; i < nums.length ; i++)
        {
            num ^= nums[i] ^ (i);
        }
        return num;
    }
}