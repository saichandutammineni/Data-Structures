class Solution {
    private int solve(int[] piles, Integer[][] dp, int i, int j){
        if(dp[i][j]!=null) return dp[i][j];
        if(i==j) return piles[i];

        return dp[i][j]=Math.max(piles[i]-solve(piles, dp, i+1, j), piles[j]-solve(piles, dp, i, j-1));
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        Integer[][] dp=new Integer[n][n];

        return solve(piles, dp, 0, n-1)>0;
    }
}