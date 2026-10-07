class Solution {
    private int solve(int[] prices, Integer[][][] dp, int k, int curr, int sells, int holding){
        if(sells==k || curr==prices.length) return 0;
        if(dp[curr][sells][holding]!=null){
            return dp[curr][sells][holding];
        }
        int temp=0;
        if(holding==0){
            temp=Math.max(-prices[curr]+solve(prices, dp, k, curr+1, sells, 1), solve(prices, dp, k, curr+1, sells, holding));
        }
        else{
            temp=Math.max(prices[curr]+solve(prices, dp, k, curr+1, sells+1, 0), solve(prices, dp, k, curr+1, sells, holding));
        }
        return dp[curr][sells][holding]=temp;
    }
    public int maxProfit(int k, int[] prices) {
         int n=prices.length;
        Integer[][][] dp=new Integer[n][k][2];

        return solve(prices, dp, k, 0, 0, 0);
    }
}