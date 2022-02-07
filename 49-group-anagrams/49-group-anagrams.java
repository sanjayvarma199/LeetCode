class Solution {
    //Time O(N*(klogK))
    //Space O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
        {
            return new ArrayList<>();
        }
        HashMap<String , List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++)
        {
            char ar[] = strs[i].toCharArray();
            Arrays.sort(ar);
            String s = new String(ar);
            if(!map.containsKey(s))
            {
                map.put(s , new ArrayList<>());
            }
            map.get(s).add(strs[i]);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String s : map.keySet())
        {
            ans.add(map.get(s));
        }
        return ans;
    }
}