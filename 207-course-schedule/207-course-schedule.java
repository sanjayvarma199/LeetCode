class Solution {
    //Time O(V+E)
    //Space O(V+E) 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Input Validation
        if(prerequisites == null || numCourses == 0)
        {
            return true;
        }
        int[] InDegrees = new int[numCourses];
        
        //Calculate the InDegrees
        for(int i = 0 ; i < prerequisites.length ; i++)
        {
            InDegrees[prerequisites[i][0]]++;
        }
        
        //To maintain dependency map
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i = 0 ; i < prerequisites.length ; i++)
        {
            int in = prerequisites[i][1] , out = prerequisites[i][0];
            if(!map.containsKey(in))
            {
                map.put(in , new ArrayList<>());
            }
            map.get(in).add(out);
        }
        
        Queue<Integer> Q = new LinkedList<>();
        
        //Couses with no prereqs
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
            List<Integer> list = map.get(curr);
            
            //Edge Case
            if(list == null) continue;
            
            for(int i : list)
            {
                InDegrees[i]--;
                if(InDegrees[i] == 0)
                {
                    Q.add(i);
                }
            }
        }
        
        for(int i : InDegrees)
        {
            if(i != 0)
            {
                return false;
            }
        }
        return true;
    }
}