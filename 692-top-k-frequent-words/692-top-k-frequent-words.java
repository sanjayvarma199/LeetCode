class Solution {
    //Time O(Nlogk)
    //Space O(N)
    public List<String> topKFrequent(String[] words, int k) {
        if(words == null || words.length == 0)
        {
            return new ArrayList<>();
        }
        Map<String , Integer> map = new HashMap<>();
        for(String s : words)
        {
            map.put(s , map.getOrDefault(s , 0)+1);
        }
        PriorityQueue<String> PQ = new PriorityQueue<>((a,b) -> (map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b)));
        
        for(String s : map.keySet())
        {
            PQ.add(s);
            if(PQ.size() > k)
            {
                PQ.poll();
            }
        }
        List<String> ans = new LinkedList<>();
        while(!PQ.isEmpty())
        {
            ans.add(0 , PQ.poll());
        }
        return ans;
    }
}