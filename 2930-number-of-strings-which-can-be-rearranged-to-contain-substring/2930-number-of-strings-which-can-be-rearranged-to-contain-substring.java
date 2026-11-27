class Solution {
    private final int MOD=1000000007;
    private long factorn;
    private long factor(int n){
        long ans=1;
        while(n>1){
            ans*=n;
            n--;
        }
        return ans;
    }
    private int solve(int index, int l, int e, int t, int n, int[][][][] dp){
        if(index==n){
            if(l>0 && e>1 && t>0){
                return 1;
            }
            return 0;
        }

        if(dp[index][l][e][t]!=-1){
            return dp[index][l][e][t];
        }
        long count=0;
        for(int i=0;i<26;i++){
            if(i==4 && e<2){
                count=(count+solve(index+1, l, e+1, t, n, dp))%MOD;
            }
            else if(i==11 && l<1){
                count=(count+solve(index+1, l+1, e, t,n, dp))%MOD;
            }
            else if(i==19 && t<1){
                count=(count+solve(index+1, l, e, t+1,n, dp))%MOD;
            }
            else{
                count=(count+solve(index+1, l, e, t,n, dp))%MOD;
            }
        }

        return dp[index][l][e][t]=(int)count%MOD;
    }
    public int stringCount(int n) {
        if(n<4) return 0;
        
        int[][][][] dp=new int[n][2][3][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        // int[] alp=new int[26];
        return solve(0, 0, 0,0, n, dp);
    }
}