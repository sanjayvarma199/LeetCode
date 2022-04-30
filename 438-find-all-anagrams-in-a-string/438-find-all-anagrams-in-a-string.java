class Solution {
    //Time O(N)
    //Space O(1)
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0)
        {
            return new ArrayList<>();
        }
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < p.length() ; i++)
        {
            char c = p.charAt(i);
            map.put(c , map.getOrDefault(c , 0)+1);
        }
        
        int match = map.size() , j = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c_in = s.charAt(i);
            if(map.containsKey(c_in))
            {
                map.put(c_in , map.get(c_in)-1);
                if(map.get(c_in) == 0)
                {
                    match--;
                }
            }
            if(i >= p.length())
            {
                char c_out = s.charAt(i-p.length());
                if(map.containsKey(c_out))
                {
                    map.put(c_out , map.get(c_out)+1);
                    if(map.get(c_out) == 1)
                    {
                        match++;
                    }
                }
            }
            if(match == 0) result.add(i-p.length()+1);
        }
        return result;
    }
}