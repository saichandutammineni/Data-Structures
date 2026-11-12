class Solution {
    private int solve(int[] dp, int max, int total, int curr, int K){
        if(curr>=total){
            return 0;
        }
        if(dp[K]!=-1) return dp[K];
        
        for(int i=1;i<max+1;i++){
            if(((K&(1<<i))==0) && (solve(dp, max, total, curr+i, K|(1<<i))==0)){
                return dp[K]=1;
            }
        }
        return dp[K]=0;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal==0) return true;
        int[] dp=new int[1<<(maxChoosableInteger+1)];
        Arrays.fill(dp, -1);
        int maxAllowed=maxChoosableInteger*(maxChoosableInteger+1)/2;
        if(maxAllowed<desiredTotal) return false;
        return solve(dp, maxChoosableInteger, desiredTotal, 0, 0)==1;
    }
}