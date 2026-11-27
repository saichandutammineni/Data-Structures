class Solution {
    
    private int solve(int vi, int index, int n, Integer[][] dp){
        if(index==n){
                return 1;
        }

        if(dp[vi][index]!=null) return dp[vi][index];
        int count=0;
        for(int i=vi;i<5;i++){
            count+=(solve(i, index+1, n, dp));
        }
        return dp[vi][index]=count;
    }
    public int countVowelStrings(int n) {
        Integer[][] dp=new Integer[5][n]; 
        return solve(0, 0, n, dp);
    }
}