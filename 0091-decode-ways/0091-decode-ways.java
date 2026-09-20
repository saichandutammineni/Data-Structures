class Solution {
    private int solve(String s, Integer[] dp, int index, int val){
        if(index==s.length() && val>=0 && val<=26){
            return 1;
        }
        if(val>26){
            return 0;
        }
        if(dp[index]!=null){
            return dp[index];
        }

        if(s.charAt(index)=='0'){
            return dp[index]=0;
        }

        int first=s.charAt(index)-'0';
        int temp=solve(s, dp, index+1, first);
        if(index+1<s.length()){

            int second=first*10 + s.charAt(index+1)-'0';
            temp+=solve(s, dp, index+2, second);
        }
        return dp[index]=temp;
    }
    public int numDecodings(String s) {
        Integer[] dp=new Integer[s.length()];
        return solve(s, dp, 0, 0);
    }
}