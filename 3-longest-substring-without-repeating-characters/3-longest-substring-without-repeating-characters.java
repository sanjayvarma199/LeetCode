class Solution {
    //Time O(N)
    //Space O(1)
    public int lengthOfLongestSubstring(String s) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int ans = 0 , i = 0 , j = 0;
        Map<Character , Integer> map = new HashMap<>();
        while(j < s.length())
        {
            char c = s.charAt(j);
            if(map.containsKey(c) && i <= map.get(c))
            {
                i = map.get(c) + 1;
            }
            map.put(c , j);
            ans = Math.max(ans , j-i+1);
            j++;
        }
        return ans;
    }
}