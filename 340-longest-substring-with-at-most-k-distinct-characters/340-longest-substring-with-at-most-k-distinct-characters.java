class Solution {
    //Time O(N)
    //Space O(1)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        HashMap<Character , Integer> map = new HashMap<>();
        int left = 0 , right = 0 , result = 0;
        while(right < s.length())
        {
            char c = s.charAt(right);
            map.put(c , map.getOrDefault(c , 0) + 1);
            while(map.size() > k)
            {
                char left_char = s.charAt(left);
                map.put(left_char , map.get(left_char)-1);
                map.remove(left_char , 0);
                left++;
            }
            result = Math.max(result , right - left + 1);
            right++;
        }
        return result;
    }
}