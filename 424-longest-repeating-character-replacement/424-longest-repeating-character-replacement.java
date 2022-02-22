class Solution {
    //Time O(N)
    //Space O(1)
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        Map<Character , Integer> map = new HashMap<>(); // Maintain a freq map
        
        int Max_Count = 0 , left = 0 , result = 0;
        
        //Process all the elements by maintaing the valid window uding Left and Right
        for(int right = 0 ; right < s.length() ; right++)
        {
            char c = s.charAt(right);
            map.put(c , map.getOrDefault(c , 0)+1);
            Max_Count  = Math.max(Max_Count , map.get(c));
            
            if(right - left + 1 - Max_Count > k)
            {
                char Left_Char = s.charAt(left);
                map.put(Left_Char , map.get(Left_Char)-1);
                left++;
            }
            result = Math.max(result , right - left + 1);
        }
        return result;
    }
}