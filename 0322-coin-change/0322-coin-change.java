class Solution {

    private int solve(int[] coins, int amount, int[] dp) {
    if (amount == 0) return 0;          // base case
    if (dp[amount] != -1) return dp[amount];

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
        if (amount - coins[i] >= 0) {
            int sub = solve(coins, amount - coins[i], dp);
            if (sub != -1) {            // only add if sub-amount is possible
                ans = Math.min(ans, 1 + sub);
            }
        }
    }

    dp[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;
    return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1]; // no.of coins required for an amount

        //Arrays.fill(dp, -1);
        dp[0]=0;
        
        for(int i=1;i<=amount;i++){
            int ans=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=-1)
                    ans=Math.min(ans, 1+dp[i-coins[j]]);
                
            }
            dp[i]=(ans==Integer.MAX_VALUE) ? -1 : ans;
        }

        //solve(coins, amount, dp);
        return dp[amount];
    }
}