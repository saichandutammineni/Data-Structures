class Solution {
    private int countWays(int n, int curr, int[] dp){
        if(n==curr) return 1;
        if(curr>n) return 0;
        if(dp[curr]!=-1) return dp[curr];

        dp[curr]=countWays(n, curr+1, dp)+countWays(n, curr+2, dp);
        return dp[curr];
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1]; // n+1 stages
        Arrays.fill(dp, -1);
        return countWays(n, 0, dp);
    }
}