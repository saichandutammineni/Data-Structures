class Solution {
    // class GraphNode{
    //     String s;

    // }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs=new HashSet<>();
        for(String str: wordList){
            hs.add(str);
        }

        if(!hs.contains(endWord)) return 0;
        
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        int lengthOfPath=1;
        while(!q.isEmpty()){
            int n=q.size();
            lengthOfPath++;
            while(n-->0){
            String curr=q.poll();
            char[] ch=curr.toCharArray();

            for(int i=0;i<ch.length;i++){
                char orig=ch[i];
                for(char t='a';t<='z';t++){

                    ch[i]=t;
                    String s1=new String(ch);
                    if(s1.equals(endWord)){
                        return lengthOfPath;
                    }
                    if(hs.contains(s1)){
                        q.offer(s1);
                        hs.remove(s1); // mark visited node
                    }
                }
                ch[i]=orig;
            }
            }
        }

        return 0;
    }
}