class Solution {
    //Time O(N)
    //Space O(1)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        Map<Character , Integer> map = new HashMap<>();
        int left = 0 , result = 0;
        
        //Start processing the string using right pointer
        for(int right = 0 ; right < s.length() ; right++)
        {
            char c = s.charAt(right);
            map.put(c , map.getOrDefault(c , 0) + 1);
            while(map.size() > k)
            {
                char Left_char = s.charAt(left);
                map.put(Left_char , map.get(Left_char)-1);
                map.remove(Left_char , 0);
                left++;
            }
            result = Math.max(result , right - left + 1);
        }
        return result;
    }
}