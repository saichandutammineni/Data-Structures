class Solution {
    private int calculate(int curr, int n, int[] dp){
        if(curr<0) return 0;
        if(dp[curr]!=-1){
            return dp[curr];
        }

        

        dp[curr]=calculate(curr-1, n, dp)+calculate(curr-2, n, dp);
        return dp[curr];
        
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        dp[0]=1;
        dp[1]=1;
        
        return calculate(n, n, dp);
    }
}