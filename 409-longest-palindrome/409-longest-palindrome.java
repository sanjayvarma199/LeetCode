class Solution {
    //Time O(N)
    //Space O(1)
    public int longestPalindrome(String s) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int len = 0;
        //Map to maintain freq
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c , 0)+1);
            if(map.get(c) > 1)
            {
                len += 2;
                map.put(c , map.get(c)-2);
            }
        }
        for(int val : map.values())
        {
            if(val == 1)
            {
                len++;
                break;
            }
        }
        return len; 
    }
}