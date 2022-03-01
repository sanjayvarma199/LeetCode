class Solution {
    //Time amortized O(N)
    //Space O(1)
    int k;
    public int[][] kClosest(int[][] points, int k) {
        if(points == null || points.length == 0)
        {
            return points;
        }
        this.k = k;
        return QuickSelect(points);
    }
    private int[][] QuickSelect(int[][] points)
    {
        int low = 0 , high = points.length-1 , pivot = points.length;
        while(pivot != k)
        {
            pivot = partition(points , low , high);
            if(pivot < k)
            {
                low = pivot;
            }
            else
            {
                high = pivot-1;
            }
        }
        return Arrays.copyOf(points , k);
    }
    private int partition(int[][] points , int low , int high)
    {
        int[] pivot = points[low + (high-low)/2];
        while(low < high)
        {
            if(distance(points[low]) >= distance(pivot))
            {
                swap(points , low , high);
                high--;
            }
            else
            {
                low++;
            }
        }
        if(distance(points[low]) < distance(pivot))
        {
            low++;
        }
        return low;
    }
    private void swap(int[][] points, int i , int p)
    {
                int[] temp = points[i];
                points[i] = points[p];
                points[p] = temp;
                p++;
    }
    private int distance(int[] point)
    {
        return point[0]*point[0] + point[1]*point[1];
    }
}