class Solution {
    //Time O(N)
    //Space O(1)
    public boolean isAnagram(String s, String t) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return false;
        }
        if(s.length() != t.length()) return false;
        Map<Character , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c , 0)+1);
        }
        
        for(int i = 0 ; i < t.length() ; i++)
        {
            char c = t.charAt(i);
            if(!map.containsKey(c))
            {
                return false;
            }
            map.put(c , map.get(c)-1);
            map.remove(c , 0);
        }
        return true;
    }
}