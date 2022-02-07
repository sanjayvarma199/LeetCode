class Solution {
    //Time O(N*k)
    //Space O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
        {
            return new ArrayList<>();
        }
        HashMap<String , List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++)
        {
            String s = getCount(strs[i]);
            //System.out.println(s);
            if(!map.containsKey(s))
            {
                map.put(s , new ArrayList<>());
            }
            map.get(s).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
    
    private String getCount(String s)
    {
        int ar[] = new int[26];
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            ar[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < ar.length ; i++)
        {
            sb.append('#');
            sb.append(ar[i]);
        }
        return sb.toString();
    }
}