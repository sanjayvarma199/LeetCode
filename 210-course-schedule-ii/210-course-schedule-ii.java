class Solution {
    //TC O(V+E)
    //SC O(V+E)
    public int[] findOrder(int numCourses, int[][] prereq) {
        //Input Validation
        if(numCourses == 0)
        {
            return new int[] {};
        }
        int n = prereq.length;
        int InDegrees[] = new int[numCourses];
        
        //Calculate InDegrees
        for(int i = 0 ; i < n ; i++)
        {
            InDegrees[prereq[i][0]]++;
        }
        
        //Create dependencies
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
        
        int[] ans = new int[numCourses];
        int count = 0;
        
        //Add courses with no dependencies
        for(int i = 0 ; i < numCourses ; i++)
        {
            if(InDegrees[i] == 0)
            {
                Q.add(i);
                ans[count++] = i;
            }
        }
        
        while(!Q.isEmpty())
        {
            int curr = Q.poll();
            
            List<Integer> list = map.get(curr);
            if(list == null) continue;
            
            for(int i : list)
            {
                InDegrees[i]--;
                if(InDegrees[i] == 0)
                {
                    Q.add(i);
                    ans[count++] = i;
                }
            }
        }
        
        for(int i = 0 ; i < numCourses ; i++)
        {
            if(InDegrees[i] != 0)
            {
                return new int[]{};
            }
        }
        return ans;
    }
}