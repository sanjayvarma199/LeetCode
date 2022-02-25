class Solution {
    //Time O(Max(M,N))
    //Space O(M+N)
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version1.length() == 0)
        {
            return version2 == null ? 0 : -1;
        }
        String s1[] = version1.split("\\.");
        String s2[] = version2.split("\\.");
        
        for(int i = 0 ; i < Math.max(s1.length , s2.length) ; i++)
        {
            int first_num = (i >= s1.length) ? 0 : Integer.parseInt(s1[i]);
            int second_num = (i >= s2.length) ? 0 : Integer.parseInt(s2[i]);
            
            if(first_num != second_num)
            {
                return first_num > second_num ? 1 : -1;
            }
        }
        return 0;
    }
}