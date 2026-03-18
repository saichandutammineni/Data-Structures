class Solution {
    private int fibo(int curr, int[] dp){
        if(curr==0) return 0;
        if(curr==1) return 1;
        //if(dp[curr]!=-1) return dp[curr];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=curr;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        //dp[curr]=fibo(curr-1, dp)+fibo(curr-2, dp);
        return dp[curr];
    }
    public int fib(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);

        return fibo(n, dp);
    }
}