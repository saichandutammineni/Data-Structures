class Solution {
    private boolean solve(String s, String p, int i, int j, Boolean[][] dp){
        if(j>=p.length()){
            if(i>=s.length())
            return true;
            else return false;
        }
        if(i>=s.length()){
            while(j<p.length() && (p.charAt(j)=='*')){
                j++;
            }
            return j==p.length();
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean ans=false;
        if(p.charAt(j)=='*'){
           
            ans=solve(s,p, i, j+1, dp) || solve(s,p, i+1, j, dp);
        }
        else if(p.charAt(j)=='?'){
            ans=solve(s, p, i+1, j+1, dp);
        }
        else{
            if(i<s.length() && p.charAt(j)==s.charAt(i)){
                ans=solve(s, p, i+1, j+1, dp);
            }
            
        }
        return dp[i][j]=ans;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()+1][p.length()+1];
        return solve(s, p, 0, 0, dp);
    }
}