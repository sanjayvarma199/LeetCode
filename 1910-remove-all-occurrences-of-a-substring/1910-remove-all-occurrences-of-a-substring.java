class Solution {
    StringBuilder sb;
    public String removeOccurrences(String s, String part) {
        if(s == null)
        {
            return "";
        }
        sb = new StringBuilder(s);
        int index = 0;
        while(index <= s.length() - part.length())
        {
            int i = index , j = index+part.length();
            if(s.substring(i,j).equals(part))
            {
                sb.delete(i , j);
                return removeOccurrences(sb.toString(), part);
            }
            index++;
        }
        return sb.toString();
    }
}