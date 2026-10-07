class Solution {
    private int solve(int[] prices, Integer[][] dp, int fee, int curr, int holding){
        if(curr>=prices.length) return 0;
        if(dp[curr][holding]!=null){
            return dp[curr][holding];
        }
        int temp=0;
        if(holding==0){
            temp=Math.max(-prices[curr]-fee+solve(prices, dp,  fee, curr+1, 1), solve(prices, dp, fee, curr+1, holding));
        }
        else{
            temp=Math.max(prices[curr]+solve(prices, dp, fee, curr+1, 0), solve(prices, dp, fee, curr+1, holding));
        }
        return dp[curr][holding]=temp;
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        Integer[][] dp=new Integer[n][2];

        return solve(prices, dp, fee, 0, 0);
    }
}