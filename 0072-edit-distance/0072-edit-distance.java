class Solution {
    private int find(StringBuilder word1, StringBuilder word2, int i, int j, int[][] dp){

        // if(i>=word1.length() || j>=word2.length()){
        //     return 0;
        // }

        if(i==word1.length()) return word2.length()-j;
        else if(j==word2.length()) return word1.length()-i;

        if(dp[i][j]!=-1) return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j]=find(word1, word2, i+1, j+1, dp);
        }
        else{
            int a=find(word1, word2, i, j+1, dp)+1;

            int b=find(word1, word2, i+1, j+1, dp)+1;
            int c=find(word1, word2, i+1, j, dp)+1;
            
            dp[i][j]=Math.min(a, Math.min(b,c));
        }
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        
        int m=word1.length(), n=word2.length();
        if(m==0) return n;
        if(n==0) return m;
        StringBuilder s1=new StringBuilder(word1);
        StringBuilder s2=new StringBuilder(word2);
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        find(s1, s2, 0, 0, dp);
        return dp[0][0];
    }
}