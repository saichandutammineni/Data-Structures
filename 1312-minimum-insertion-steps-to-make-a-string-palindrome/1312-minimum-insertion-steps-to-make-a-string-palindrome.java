class Solution {
    private int solve(String s, int l, int r, Integer[][] dp){
        if(l>=r) return 0;
        else if(dp[l][r]!=null) return dp[l][r];

        int temp=0;
        if(s.charAt(l)==s.charAt(r)){
            temp=solve(s, l+1, r-1, dp);
        }
        else{
            temp=1+Math.min(solve(s, l+1, r, dp), solve(s, l, r-1, dp));
        }
        return dp[l][r]=temp;
    }
    public int minInsertions(String s) {
        int n=s.length();

        Integer[][] dp=new Integer[n][n];
        return solve(s, 0, n-1, dp);
    }
}