class Solution {
    //Time O(N + M*L) N -> sentence len ; M -> dict size
    //Space O(26*L + N)
    class TrieNode
    {
        TrieNode[] children;
        String word;
        public TrieNode()
        {
            children = new TrieNode[26];
            word = null;
        }
    }
    TrieNode root = new TrieNode();
    private void Insert(String s)
    {
        TrieNode curr = root;
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(curr.children[c-'a'] == null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = s;
    }
    
    private String Prefix_Root(String s)
    {
        TrieNode curr = root;
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(curr.children[c-'a'] == null)
            {
                return s;
            }
            if(curr.children[c-'a'].word != null)
            {
                return curr.children[c-'a'].word;
            }
            curr = curr.children[c-'a'];
        }
        return curr.word;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0)
        {
            return sentence;
        }
        
        for(String s : dictionary)
        {
            Insert(s);
        }
        
        StringBuilder sb = new StringBuilder();
        
        String ar[] = sentence.split(" ");
        
        for(String s : ar)
        {
            String temp = Prefix_Root(s);
            if(temp != null) sb.append(temp);
            else sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}