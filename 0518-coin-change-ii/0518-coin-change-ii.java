class Solution {
    private int solve(int amount, int[][] dp, int[] coins, int index){
        if(amount==0) return 1;
        if(index==coins.length || amount<0) return 0;

        if(dp[amount][index]!=-1) return dp[amount][index];
        int sum=0;
        
        sum+=solve(amount-coins[index], dp, coins, index);
        sum+=solve(amount, dp, coins, index+1);

        return dp[amount][index]=sum;
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[amount+1][coins.length];
        for(int i=1;i<dp.length;i++)
            Arrays.fill(dp[i], -1);
        //dp[0][0]=1;
        
        return solve(amount, dp, coins, 0);
    }
}