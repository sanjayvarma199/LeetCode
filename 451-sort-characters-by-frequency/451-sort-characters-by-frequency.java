class Solution {
    //Time O(N)
    //Space O(N)
    public String frequencySort(String s) {
        if(s == null || s.length() == 0)
        {
            return s;
        }
        int max = 0;
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c , 0) + 1);
            max = Math.max(max , map.get(c));
        }
        List<List<Character>> list = new ArrayList<>();
        for(int i = 0 ; i <= max ; i++)
        {
             list.add(new ArrayList<>());
        }
        for(char c : map.keySet())
        {
            int i = map.get(c);
            list.get(i).add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = max ; i >= 0 ; i--)
        {
            for(char c : list.get(i))
            {
                for(int j = 0 ; j < i ; j++)
                {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}