class Solution {
    //Time O(N)
    //Space O(1)
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        
        int left = 0 , result = 0;
        Map<Character , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c) && left <= map.get(c))
            {
                left = map.get(c) + 1;
            }
            map.put(c , i);
            result = Math.max(i-left+1, result);
        }
        return result;
    }
}