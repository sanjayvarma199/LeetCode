class Solution {
    //Time O(V+E) -> DFS ; O(E) -> build adj ; V*log(V) -> sort
    //Space O(V+E) V to store visited and E to store adj
    int n;
    List<Integer> adj[];
    boolean visited[];
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(s == null || s.length() == 0)
        {
            return "";
        }
        n = s.length();
        adj = new ArrayList[n];
        visited = new boolean[n];
        
        char answer[] = new char[n];
        
        //Create an Adjacency List
        for (int i = 0; i < s.length(); i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for(List<Integer> Edge : pairs)
        {
            int source = Edge.get(0) , destination = Edge.get(1);
            
            adj[source].add(destination);
            adj[destination].add(source);
        }
        
        for(int vertice = 0 ; vertice < n ; vertice++)
        {
            if(!visited[vertice])
            {
                List<Character> characters = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                
                DFS(s , vertice , characters , indices);
                
                Collections.sort(characters);
                Collections.sort(indices);
                
                for(int i = 0 ; i < characters.size() ; i++)
                {
                    answer[indices.get(i)] = characters.get(i);
                }
            }
        }
        return new String(answer);
    }
    
    private void DFS(String s , int vertice , List<Character> characters , List<Integer> indices)
    {
        characters.add(s.charAt(vertice));
        indices.add(vertice);
        
        visited[vertice] = true;
        
        for(int i : adj[vertice])
        {
            if(!visited[i])
            {
                DFS(s , i , characters , indices);
            }
        }
    }
}