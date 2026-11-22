class Solution {
    private int solve(Integer[][] dp, String s, String t, int i, int j){
        if(j==t.length()){
            
            return 1;
        }
        if(s.length()==i) return 0;

        if(dp[i][j]!=null) return dp[i][j];
        int skip=solve(dp, s, t, i+1, j);
        int take=0;
        if(s.charAt(i)==t.charAt(j)){
            take=solve(dp, s, t, i+1, j+1);
        }

        return dp[i][j]=skip+take;
    }
    public int numDistinct(String s, String t) {
        Integer[][] dp=new Integer[s.length()][t.length()];

        return solve(dp, s, t, 0, 0);
    }
}