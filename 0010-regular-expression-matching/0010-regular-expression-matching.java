class Solution {
    private boolean solve(Boolean[][] dp, String s, String p, int i, int j){
        if(j>=p.length()){
            if(i>=s.length())
            return true;
            else
            return false;
        }
        if(i>=s.length()){
            if(j+1<p.length() && p.charAt(j+1)=='*'){
                return solve(dp, s, p, i, j+2);
            }
            return false;
        }
        

        if(dp[i][j]!=null) return dp[i][j];

        boolean temp=false;
        if(p.charAt(j)!='.' && p.charAt(j)!='*'){
            if(j+1<p.length() && p.charAt(j+1)=='*'){
                int t=i; // 0 or more
                while(t<s.length() && s.charAt(t)==p.charAt(j)){
                    temp|=solve(dp, s, p, t, j+2);
                    t++;
                }
                if(!temp && t<=s.length()){
                    temp|=solve(dp, s, p, t, j+2);
                }
            }
            else{
            if(p.charAt(j)==s.charAt(i)) 
            temp= solve(dp, s, p, i+1, j+1);
            else temp=false;
            }
        }
        else if(p.charAt(j)=='.'){
            if(j+1<p.length() && p.charAt(j+1)=='*'){
                int t=i; // 0 or more
                while(t<=s.length()){
                    temp|=solve(dp, s, p, t, j+2);
                    t++;
                }
                // if(!temp){
                //     temp|=solve(dp, s, p, t, j+2);
                // }
            }
            else{
            
            temp= solve(dp, s, p, i+1, j+1);
            
            }
        }
        return dp[i][j]=temp;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()+1][p.length()+1];

        return solve(dp, s, p, 0, 0);
    }
}