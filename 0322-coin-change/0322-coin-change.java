class Solution {
    private int solve(int[][] dp, int sum, int index, int[] coins, int amount){
        if(amount==sum){
            return 0;
        }
        if(index==coins.length){
            return Integer.MAX_VALUE/2;
        }

        if(dp[sum][index]!=-1) return dp[sum][index]; 
        int a=Integer.MAX_VALUE, b=Integer.MAX_VALUE;
        if(coins[index]+sum<=amount){
            a=1+solve(dp, sum+coins[index], index, coins, amount);
        }
        
        b=solve(dp, sum, index+1, coins, amount);
        
        return dp[sum][index]=Math.min(a,b);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        if(amount==0) return 0;
        Arrays.sort(coins);
        
        for(int l=0, r=n-1;l<r;l++, r--){
            int temp=coins[l];
            coins[l]=coins[r];
            coins[r]=temp;
        }
        int[][] dp=new int[amount+1][n];
        for(int i=0;i<amount+1;i++){
            Arrays.fill(dp[i], -1);
        }
        solve(dp, 0, 0, coins, amount);

        return dp[0][0]<Integer.MAX_VALUE/2 ? dp[0][0] : -1;
    }
}