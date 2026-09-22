class Solution {
    private int solve(int[] prices, Integer[][] dp, int index, int bought){
        if(index==prices.length || bought>=prices.length-1){
            return 0;
        }

        if(dp[index][bought]!=null){
            return dp[index][bought];
        }

        int temp=0;
        if(bought>=index){
            temp=Math.min(prices[index]+solve(prices, dp, index+1, index+index+1), solve(prices, dp, index+1, bought));
        }
        else{
            temp=prices[index]+solve(prices, dp, index+1, index+index+1);
        }
        return dp[index][bought]=temp;
    }
    public int minimumCoins(int[] prices) {
        Integer[][] dp=new Integer[prices.length][prices.length];

        return prices[0]+solve(prices, dp, 1, 1);
    }
}