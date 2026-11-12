

class Solution {
    int MOD=1_000_000_007;
    private int solve(int curr, int i, Integer[][] dp, int[][] types, int target){
        if(curr==target){
            return 1;
        }
        else if(curr>target || i==types.length){
            return 0;
        }
        if(dp[curr][i]!=null){
            return dp[curr][i];
        }

        long ways=0;
        
        
        for(int j=0;j<=types[i][0];j++){
            int newSum=curr+j*types[i][1];
            ways+=solve(newSum, i+1, dp, types, target)%MOD;
        }
        
        return dp[curr][i]=(int)(ways%MOD);
    }
    public int waysToReachTarget(int target, int[][] types) {
        Integer[][] dp=new Integer[target+1][types.length];

        return solve(0, 0, dp, types, target);
    }
}