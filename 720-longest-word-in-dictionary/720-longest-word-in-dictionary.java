class Solution {
    //Time O(N*L + L) L -> Longest word
    //Space O(26*L)
    class Node
    {
        Node children[];
        String Word;
        public Node()
        {
            children = new Node[26];
            Word = null;
        }
    }
    
    Node root;
    private void Insert(String s)
    {
        Node curr = root;
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(curr.children[c-'a'] == null)
            {
                curr.children[c-'a'] = new Node();
            }
            curr = curr.children[c-'a'];
        }
        curr.Word = s;
    }
    
    public String longestWord(String[] words) {
        root = new Node();
        
        StringBuilder sb = new StringBuilder();
        
        Queue<Node> Q = new LinkedList<>();
        
        //Insert all the words into trie
        for(String s : words)
        {
            Insert(s);
        }
        
        Node curr = root;
        for(int i = 25 ; i >= 0 ; i--)
        {
            if(curr.children[i] != null)
            {
                Q.add(curr.children[i]);
            }
        }
        String result = null;
        while(!Q.isEmpty())
        {
            curr = Q.poll();
            for(int i = 25 ; i >= 0 ; i--)
            {
                if(curr.children[i] != null &&  curr.Word != null)
                {
                    Q.add(curr.children[i]);
                }
            }
            if(curr.Word != null) result = curr.Word;
        }
        if(result == null) return "";
        return result;
        
    }
}