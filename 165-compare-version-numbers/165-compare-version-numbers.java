class Solution {
    //Time O(Max(M,N))
    //Space O(1)
    public int compareVersion(String version1, String version2) {
        int i = 0 , j = 0;
        int CurrVersion1 , CurrVersion2; // to maintain each every block of both versions
        
        //Process both the strings
        while(i < version1.length() || j < version2.length())
        {
            CurrVersion1 = 0;
            while(i < version1.length() && version1.charAt(i) != '.')
            {
                CurrVersion1 = CurrVersion1*10 + version1.charAt(i) - '0';
                i++;
            }
            CurrVersion2 = 0;
            while(j < version2.length() && version2.charAt(j) != '.')
            {
                CurrVersion2 = CurrVersion2*10 + version2.charAt(j) - '0';
                j++;
            }
            if(CurrVersion1 > CurrVersion2) return 1;
            else if(CurrVersion1 < CurrVersion2) return -1;
            i++;
            j++;
        }
        return 0;
    }
}