class Solution {
    //Time O(N)
    //Space O(1)
    public int lengthOfLongestSubstring(String s) {
         if(s == null || s.length() == 0)
         {
             return 0;
         }
         Map<Character , Integer> map = new HashMap<>();
         
         int left = 0 , result = 0;
         for(int right = 0 ; right < s.length() ; right++)
         {
             char c = s.charAt(right);
             if(map.containsKey(c) && left <= map.get(c))
             {
                 left = map.get(c) + 1;
             }
             map.put(c , right); // Update the latest position
             result = Math.max(result , right-left+1);
         }
        return result;
    }
}