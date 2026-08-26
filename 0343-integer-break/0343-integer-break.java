class Solution {
    private int solve(int[] dp, int x){
        if(x<=0) return 0;
        if(dp[x]!=-1) return dp[x];

        int temp=1;
        for(int i=1;i<=x;i++){
            temp=Math.max(temp, Math.max(i*solve(dp, x-i) , i*(x-i)));
        }
        return dp[x]=temp;
    }
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        dp[0]=0;
        dp[1]=1;
        //dp[2]=2;
        
        return solve(dp, n);
    }
}