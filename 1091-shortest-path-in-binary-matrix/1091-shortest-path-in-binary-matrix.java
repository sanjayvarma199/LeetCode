class Solution {
    //Time O(N^2)
    //Space O(N)
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        //Input Validation
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        if(grid.length == 1 && grid[0][0] == 0)
        {
            return 1;
        }
        int m = grid.length;
        Queue<pair> Q = new LinkedList<>();
        if(grid[0][0] == 0) Q.add(new pair(0,0));
        grid[0][0] = -1;
        //Process Q Elements
        int level = 1;
        while(!Q.isEmpty())
        {
              int size = Q.size();
              for(int i = 0 ; i < size ; i++)
              {
                  pair p = Q.poll();
                  for(int[] dir : dirs)
                  {
                      int new_x = dir[0] + p.x;
                      int new_y = dir[1] + p.y;
                      //Return when it reaches end
                      if(new_x == grid.length-1 && new_y == grid[0].length-1 && grid[new_x][new_y] == 0) return level+1;
                      if(new_x >=0 && new_x < m && new_y >= 0 && new_y < m && grid[new_x][new_y] == 0)
                      {
                          //Visited
                          grid[new_x][new_y] = -1;
                          Q.add(new pair(new_x , new_y));
                      }
                  }
              }
              level++;
        }
        return -1;
    }
}
class pair
{
    int x , y;
    public pair(int x , int y)
    {
        this.x = x;
        this.y = y;
    }
}