class Solution {
    private int solve(String s, int[] dp, int index){
        if(index==s.length()){
            return 1;
        }
        if(dp[index]!=-1){
            return dp[index];
        }

        if(s.charAt(index)=='0'){
            // if(index>0 && (s.charAt(index-1)=='1' || s.charAt(index-1)=='2')){
            //     return dp[index]=solve(s, dp, index+1);
            // }
            // else{
                return dp[index]=0;
            // }
        }

        if(s.charAt(index)=='1'){
            int temp=0;
            
            if(index+1<s.length() && s.charAt(index+1)=='0'){
                temp=solve(s, dp, index+2);
            }
            else if(index+1<s.length() && s.charAt(index+1)!='0'){
                temp=solve(s, dp, index+1)+solve(s, dp, index+2);
            }
            else{
                temp=solve(s, dp, index+1);
            }
            return dp[index]=temp;
        }
        if(s.charAt(index)=='2'){
            HashSet<Character> set=new HashSet<>(Arrays.asList('1', '2', '3', '4','5', '6'));
            if(index+1<s.length() && set.contains(s.charAt(index+1))){
                return dp[index]=solve(s, dp, index+1)+solve(s, dp, index+2);
            }
            else if(index+1<s.length() && s.charAt(index+1)=='0'){
                return dp[index]=solve(s, dp, index+2);
            }
            else{
                return dp[index]=solve(s, dp, index+1);
            }
        }
        return dp[index]=solve(s, dp, index+1);
    }
    public int numDecodings(String s) {
        //StringBuilder sb=new StringBuilder("");

        int[] dp=new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, dp, 0);
    }
}