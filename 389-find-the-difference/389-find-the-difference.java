class Solution {
    //Time O(N)
    //Space O(1)
    public char findTheDifference(String s, String t) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c , 0)+1);
        }
        for(int i = 0 ; i < t.length() ; i++)
        {
            char c = t.charAt(i);
            if(map.containsKey(c))
            {
                map.put(c , map.get(c) - 1);
                map.remove(c , 0);
            }
            else
            {
                return c;
            }
        }
        for(char c : map.keySet())
        {
            return c;
        }
        return 'a';
    }
}