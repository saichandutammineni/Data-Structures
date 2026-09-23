class Solution {
    private int solve(String s, Integer[][] dp, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=null) return dp[i][j];

        int temp=0;
        if(s.charAt(i)==s.charAt(j)){
            temp=2+solve(s, dp, i+1, j-1);
        }
        else{
            temp=Math.max(solve(s, dp, i+1, j), solve(s, dp, i, j-1));
        }

        return dp[i][j]=temp;
    }
    public int longestPalindromeSubseq(String s) {
        Integer[][] dp=new Integer[s.length()][s.length()];

        return solve(s, dp, 0, s.length()-1);
    }
}