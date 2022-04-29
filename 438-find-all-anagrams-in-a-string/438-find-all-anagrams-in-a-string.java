class Solution {
    //Time O(N)
    //Space O(1)
    Map<Character , Integer> p_map;
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0)
        {
            return new ArrayList<>();
        }
        int i = 0 , j = 0;
        List<Integer> list = new ArrayList<>();
        
        p_map = new HashMap<>();
        Map<Character , Integer> map = new HashMap<>();
        
        for(int k = 0 ; k < p.length() ; k++)
        {
            char c = p.charAt(k);
            p_map.put(c , p_map.getOrDefault(c , 0)+1);
        }
        
        while(j < s.length())
        {
            char c = s.charAt(j);
            map.put(c , map.getOrDefault(c , 0)+1);
            if(j >= p.length())
            {
                map.put(s.charAt(i) , map.get(s.charAt(i))-1);
                map.remove(s.charAt(i) , 0);
                i++;
            }
            if(map.equals(p_map))
            {
                    list.add(i);
            }
            
            j++;
        }
        return list;
    }
}