class Solution {
    int MOD=1000000007;
    private int solve(int n, Integer[][] dp, int x, int index, int sum){
        if(sum==n){
            return 1;
        }
        if(sum>n || index>=dp[0].length){
            return 0;
        }
        int skip=0, take=0;
        if(dp[sum][index]!=null) return dp[sum][index];
        
        skip=solve(n, dp, x, index+1, sum);
        int add=(int)Math.pow(index, x);
        take=solve(n, dp, x, index+1, sum+add);

        
        return dp[sum][index]=(skip%MOD + take%MOD)%MOD;

    }
    public int numberOfWays(int n, int x) {
        int m=(int)Math.pow(n, 1.0/x)+1;

        Integer[][] dp=new Integer[n+1][m+1];
        return solve(n, dp, x, 1, 0);
    }
}