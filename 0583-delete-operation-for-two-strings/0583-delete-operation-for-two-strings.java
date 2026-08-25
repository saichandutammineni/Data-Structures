class Solution {
    private int lcs(String w1, String w2, int x, int y, int[][] dp){
        if(x>=w1.length() || y>=w2.length()) return 0;
        if(dp[x][y]!=-1) return dp[x][y];

        if(w1.charAt(x)==w2.charAt(y)){
            return dp[x][y]=1+lcs(w1, w2, x+1, y+1, dp);
        }
        else{
            return dp[x][y]=Math.max(lcs(w1, w2, x+1, y, dp), lcs(w1, w2, x, y+1, dp));
        }
    }
    public int minDistance(String word1, String word2) {
        // finding LCS
        int[][] dp=new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++) Arrays.fill(dp[i], -1);
        int temp=lcs(word1, word2, 0, 0, dp);

        return word1.length()+word2.length()-2*temp;
    }
}