class Solution {
    //TC O(V+E)
    //SC O(v+E)
    public boolean canFinish(int numCourses, int[][] prereq) {
        if(prereq == null || prereq.length == 0)
        {
            return true;
        }
        int n = prereq.length;
        int[] InDegrees = new int[numCourses];
        for(int i = 0 ; i < n ; i++)
        {
            InDegrees[prereq[i][0]]++;
        }
        
        Map<Integer , List<Integer>> map = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++)
        {
            int in = prereq[i][1] , out = prereq[i][0];
            if(!map.containsKey(in))
            {
                map.put(in , new ArrayList<>());
            }
            map.get(in).add(out);
        }
        
        Queue<Integer> Q = new LinkedList<>();
        
        for(int i = 0 ; i < numCourses ; i++)
        {
            if(InDegrees[i] == 0)
            {
                Q.add(i);
            }
        }
        
        while(!Q.isEmpty())
        {
            int curr = Q.poll();
            List<Integer> curr_list = map.get(curr);
            if(curr_list == null) continue;
            for(int depend : curr_list)
            {
                InDegrees[depend]--;
                if(InDegrees[depend] == 0)
                {
                    Q.add(depend);
                }
            }
        }
        
        for(int i = 0 ; i < numCourses ; i++)
        {
            if(InDegrees[i] != 0)
            {
                return false;
            }
        }
        return true;
        
    }
}