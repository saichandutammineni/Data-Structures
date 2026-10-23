class Solution {
    private int solve(String s1, int p1, String s2, int p2, String s3, Integer[][] dp){
        if(p1==s1.length() && p2==s2.length()) return 1;
        if(dp[p1][p2]!=null) return dp[p1][p2];
        int temp=0, p3=p1+p2;

        if(p1==s1.length()){
            if(s2.charAt(p2)==s3.charAt(p3))
            temp=solve(s1, p1, s2, p2+1, s3, dp);
        }
        else if(p2==s2.length()){
            if(s1.charAt(p1)==s3.charAt(p3))
            temp=solve(s1, p1+1, s2, p2, s3, dp);
        }
        else if(s1.charAt(p1)==s3.charAt(p3) && s2.charAt(p2)==s3.charAt(p3)){
            if(solve(s1, p1+1, s2, p2, s3, dp)==1 || solve(s1, p1, s2, p2+1, s3, dp)==1){
                temp=1;
            }
        }
        else if(s1.charAt(p1)==s3.charAt(p3)){
            temp=solve(s1, p1+1, s2, p2, s3, dp);
        }
        else if(s2.charAt(p2)==s3.charAt(p3)){
            temp=solve(s1, p1, s2, p2+1, s3, dp);
        }
        
        return dp[p1][p2]=temp;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        Integer[][] dp=new Integer[s1.length()+1][s2.length()+1];
        return solve(s1, 0, s2, 0, s3, dp)==1;
    }
}