class Solution {
    //Time O(S + T)
    //Space O(S + T)
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0)
        {
            return s;
        }
        HashMap<Character , Integer> T_Map = new HashMap<>();
        
        // T String freq map
        for(int i = 0 ; i < t.length() ; i++)
        {
            char c = t.charAt(i);
            T_Map.put(c , T_Map.getOrDefault(c , 0) + 1);
        }
        int left = 0;
        int required = T_Map.size();
        int ans[] = {-1,0,0};
        for(int right = 0 ; right < s.length() ; right++)
        {
            char c = s.charAt(right);
            T_Map.put(c , T_Map.getOrDefault(c , 0)-1);
            if(T_Map.get(c) == 0) required--;
            //The current window contains all the chars from T
            while(required == 0)
            {
                if(ans[0] == -1 || right - left + 1 < ans[0])
                {
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
                }
                char Left_char = s.charAt(left);
                T_Map.put(Left_char , T_Map.get(Left_char)+1);
                // Left had crossed a char from T
                if(T_Map.get(Left_char) > 0) required++;
                left++;
            }
        }
        if(ans[0] == -1) return "";
        return s.substring(ans[1] , ans[2] + 1);
    }
}