class Solution {
    private int solve(int[] dp, int amount, int max){
        if(amount==0) return 0;
        if(dp[amount]!=-1) return dp[amount];
        int temp=Integer.MAX_VALUE;
        for(int i=1;i<=max;i++){
            if(amount>=i*i)
            temp=Math.min(temp, 1+solve(dp, amount-(i*i), max));
        }
        return dp[amount]=temp;
    }
    public int numSquares(int n) {
        int maxNum=1;
        
        while((maxNum+1)*(1+maxNum)<=n){
            maxNum++;
        }

        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        int res=solve(dp, n, maxNum);
        return res!=Integer.MAX_VALUE ? res : 0;
    }
}