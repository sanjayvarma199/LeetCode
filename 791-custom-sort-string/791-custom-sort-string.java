class Solution {
    //Time O(N)
    //Space O(1)
    public String customSortString(String order, String s) {
        if(order == null)
        {
            return s;
        }
        
        //Freq Map
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c , 0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < order.length() ; i++)
        {
            char c = order.charAt(i);
            if(map.containsKey(c))
            {
                for(int j = 0 ; j < map.get(c) ; j++)
                {
                    sb.append(c);
                }
                map.remove(c , map.get(c));
            }
        }
        
        for(char c : map.keySet())
        {
            for(int j = 0 ; j < map.get(c) ; j++)
            {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}