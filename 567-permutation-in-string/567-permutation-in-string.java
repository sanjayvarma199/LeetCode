class Solution {
    //Time O(N)
    //Space O(1)
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.length() == 0)
        {
            return false;
        }
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s1.length() ; i++)
        {
            char c = s1.charAt(i);
            map.put(c , map.getOrDefault(c , 0)+1);
        }
        int index = 0;
        while(index < s2.length())
        {
            int j = index + s1.length()-1;
            if(j < s2.length())
            {
                int i = index;
                HashMap<Character , Integer> map1 = new HashMap<>(map);
                while(i <= j && map1.containsKey(s2.charAt(i)))
                {
                    char c = s2.charAt(i);
                    map1.put(c , map1.get(c)-1);
                    map1.remove(c , 0);
                    i++;
                }
                if(map1.size() == 0) return true; 
            }
            index++;
        }
        return false;
    }
}
