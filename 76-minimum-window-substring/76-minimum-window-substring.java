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
        HashMap<Character , Integer> Curr_Map = new HashMap<>();
        int left = 0 , right = 0;
        int formed = 0 , required = T_Map.size();
        int ans[] = {-1,0,0};
        while(right < s.length())
        {
            char c = s.charAt(right);
            if(T_Map.containsKey(c))
            {
                Curr_Map.put(c , Curr_Map.getOrDefault(c , 0)+1);
                if(T_Map.containsKey(c) && Curr_Map.get(c).equals(T_Map.get(c)))
                {
                    formed++;
                }
                    while(formed == required && left <= right)
                    {
                        char left_char = s.charAt(left);
                        if(ans[0] == -1 || right-left+1 < ans[0])
                        {
                            ans[0] = right-left+1; ans[1] = left ; ans[2] = right;
                        }
                        if(!Curr_Map.containsKey(left_char))
                        {
                            left++;continue;
                        }
                        Curr_Map.put(left_char , Curr_Map.get(left_char)-1);
                        if(Curr_Map.get(left_char) < T_Map.get(left_char))
                        {
                            formed--;
                        }
                        left++;
                    }
            }
            right++;
        }
        if(ans[0] == -1) return "";
        return s.substring(ans[1] , ans[2] + 1);
    }
}