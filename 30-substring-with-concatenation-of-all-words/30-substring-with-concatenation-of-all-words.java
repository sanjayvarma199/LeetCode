class Solution {
    //Time O(N*L)
    //Space O(N + words.length)
    int subString_len , word_len , size;
    Map<String , Integer> map;
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0)
        {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        size = words.length;
        word_len = words[0].length();
        subString_len = size*word_len;
        
        //Create an HashMap for freq count
        map = new HashMap<>();
        
        for(String word : words)
        {
            map.put(word , map.getOrDefault(word , 0)+1);
        }
        
        //Process all the words
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < word_len ; i++)
        {
            SidingWindow(i , s , answer);
        }
        return answer;
    }
    
    private void SidingWindow(int left , String s , List<Integer> answer)
    {
        HashMap<String , Integer> map_found = new HashMap<>();
        int word_used = 0;
        boolean excess = false;
        
        for(int right = left ; right <= s.length() - word_len ; right += word_len)
        {
            
            String sub = s.substring(right , right + word_len);
            if(!map.containsKey(sub))
            {
                map_found.clear();
                word_used = 0;
                excess = false;
                left = right + word_len;
            }
            else
            {
                while(right - left == subString_len || excess)
                {
                    String Left_most = s.substring(left , left + word_len);
                    left += word_len;
                    map_found.put(Left_most , map_found.get(Left_most)-1);
                    
                    if(map_found.get(Left_most) >= map.get(Left_most))
                    {
                        excess = false;
                    }
                    else
                    {
                        word_used--;
                    }
                }
                
                map_found.put(sub , map_found.getOrDefault(sub , 0)+1);
                if(map_found.get(sub) <= map.get(sub))
                {
                    word_used++;
                }
                else
                {
                    excess = true;
                }
                
                if(word_used == size && !excess)
                {
                    answer.add(left);
                }
            }
        }
    }
}