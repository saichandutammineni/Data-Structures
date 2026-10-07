class Solution {
    private int solve(int[] prices, Integer[][] dp, int curr, int holding){
        if(curr>=prices.length) return 0;
        if(dp[curr][holding]!=null){
            return dp[curr][holding];
        }
        int temp=0;
        if(holding==0){
            temp=Math.max(-prices[curr]+solve(prices, dp, curr+1, 1), solve(prices, dp, curr+1, holding));
        }
        else{
            temp=Math.max(prices[curr]+solve(prices, dp, curr+2, 0), solve(prices, dp, curr+1, holding));
        }
        return dp[curr][holding]=temp;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer[][] dp=new Integer[n][2];

        return solve(prices, dp, 0, 0);
    }
}