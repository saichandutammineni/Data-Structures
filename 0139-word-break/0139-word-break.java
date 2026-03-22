class TrieNode{
    boolean isEnd;
    TrieNode[] next;

    TrieNode(){
        this.isEnd=false;
        this.next=new TrieNode[26];
    } 
}



class Solution {
    private void insert(String s, TrieNode tr){
        TrieNode ptr=tr;
        for(int i=0;i<s.length();i++){
            if(ptr.next[s.charAt(i)-'a']==null){
                ptr.next[s.charAt(i)-'a']=new TrieNode();
            }

            ptr=ptr.next[s.charAt(i)-'a'];

        }
        ptr.isEnd=true;
    }

    private boolean dfs(String s, int index, TrieNode root, Boolean[] dp) {
        if (index == s.length()) return true;

        if (dp[index] != null) return dp[index];

        TrieNode ptr = root;

        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);

            if (ptr.next[c - 'a'] == null) {
                break;
            }

            ptr = ptr.next[c - 'a'];

            if (ptr.isEnd) {
                if (dfs(s, i + 1, root, dp)) {
                    return dp[index] = true;
                }
            }
        }

        return dp[index] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode tr=new TrieNode();
        for(String str: wordDict){
            insert(str, tr);
        }

        TrieNode ptr=tr;
        
        Boolean[] dp=new Boolean[s.length()];
        return dfs(s, 0,ptr, dp);
    }
}