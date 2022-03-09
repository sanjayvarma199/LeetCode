class Solution {
    //Time O(NlogN)
    //Space O(1)
    public String reorganizeString(String s) {
        if(s == null || s.length() == 0)
        {
            return s;
        }
        int max = 0;
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c , 0)+1);
            max = Math.max(max , map.get(c));
        }
        if(max > (s.length()+1)/2) return "";
        //Max heap
        PriorityQueue<Character> PQ = new PriorityQueue<>((a , b) -> map.get(b) - map.get(a));
        
        for(char c : map.keySet())
        {
            PQ.add(c);
        }
        
        char ar[] = new char[s.length()];
        int index = 0;
        while(!PQ.isEmpty())
        {
            char c = PQ.poll();
            int freq = map.get(c);
            while(freq > 0)
            {
                if(index >= s.length())
                {
                    index = 1;
                }
                ar[index] = c;
                index += 2;
                freq--;
            }
        }
        return String.valueOf(ar);
    }
}