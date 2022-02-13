class Solution {
    //Time O(26*L*N)
    //Space O(N)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || beginWord.length() == 0 || !wordList.contains(endWord))
        {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for(String s : wordList)
        {
            set.add(s);
        }
        Queue<String> Q = new LinkedList<>();
        Q.add(beginWord);
        
        int level = 1;
        while(!Q.isEmpty())
        {
            int size = Q.size();
            for(int i = 0 ; i < size ; i++)
            {
                String s = Q.poll();
                char ar[] = s.toCharArray();
                for(int j = 0 ; j < ar.length ; j++)
                {
                    char original = ar[j];
                    for(char c = 'a' ; c <= 'z' ; c++)
                    {
                        ar[j] = c;
                        String modified = String.valueOf(ar);
                        
                        if(set.contains(modified))
                        {
                            if(modified.equals(endWord)) return level+1;
                            Q.add(modified);
                            set.remove(modified);
                        }
                    }
                    ar[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}