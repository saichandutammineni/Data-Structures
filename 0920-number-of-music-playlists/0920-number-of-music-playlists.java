class Solution {
    private long MOD=1000000007;
    private int solve(int neu, int old, int n, int goal, int k, int[][] dp){
        if(old==goal){
            if(neu==n && old==goal)
            return 1;

             return 0;
            
        }
        if(neu>n) return 0;

        if(dp[neu][old]!=-1){
            return dp[neu][old];
        }

        long count=0;
        
        count=(count+((long)(n-neu) * solve(neu+1, old+1, n, goal, k, dp)%MOD))%MOD;

        if(neu>k){
            count=(count+ ((long)(neu-k)* solve(neu, old+1, n, goal, k, dp)%MOD))%MOD;
        }

        return dp[neu][old]=(int)(count%MOD);

    }
    public int numMusicPlaylists(int n, int goal, int k) {
        int[][] dp=new int[n+1][goal];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, n, goal, k, dp);
    }
}