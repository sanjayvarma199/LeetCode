class Solution {
    //TC O((M*N)*3^L)
    //SC O(L)
    Set<String> set;
    List<String> ans;
    Map<Integer , Set<Character>> map;
    int max = 0;
    public List<String> findWords(char[][] board, String[] words) {
        //Input Validation
        if(board == null || board.length == 0)
        {
            return new ArrayList<>();
        }
        set = new HashSet<>();
        map = new HashMap<>();
        for(String s : words)
        {
            set.add(s);
            max = Math.max(s.length() , max);
            for(int i = 0; i < s.length() ; i++)
            {
                if(!map.containsKey(i))
                {
                    map.put(i , new HashSet<>());
                }
                map.get(i).add(s.charAt(i));
            }
        }
        ans = new ArrayList<>();
        int m = board.length , n = board[0].length;
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                helper(board , i , j , 0 , new StringBuilder());
            }
        }
        return ans;
    }
    
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private void helper(char[][] board , int i , int j , int index , StringBuilder sb)
    {
        //Base Case
        if(index >= max)
        {
            return;
        }
        //Logic
        if(map.containsKey(index) && map.get(index).contains(board[i][j]))
        {
            char temp = board[i][j];
            board[i][j] = '#';
            sb.append(temp);
            if(set.contains(sb.toString())) 
            {
                set.remove(sb.toString());
                ans.add(sb.toString());
            }
            for(int[] dir : dirs)
            {
                int row = dir[0] + i;
                int col = dir[1] + j;
                if(row >= 0 && col >= 0 && row < board.length && col < board[0].length && board[row][col] != '#')
                {
                    helper(board , row , col , index+1 , sb);
                }
            }
            sb.deleteCharAt(sb.length()-1);
            board[i][j] = temp;
        }
    }
}