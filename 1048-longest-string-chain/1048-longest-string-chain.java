class Solution {
    private boolean isPredecessor(String a, String b){
        if(a.length()+1!=b.length()) return false;
        boolean skip=true;
        int i=0, j=0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }
            else if(skip){
                skip=false;
                j++;
            }
            else{
                return false;
            }
        }
        if(j<b.length()){
            if(skip && j==b.length()-1) return true;
             else return false;
        }
        if(skip) return false;
        return true;
    }
    private int solve(String[] words, Integer[][] dp, int i, int p){
        if(i==words.length){
            return 0;
        }
        if(dp[i][p]!=null){
            return dp[i][p];
        }

        int temp=0;
        if(p==0){
            temp=Math.max(1+solve(words, dp, i+1, i+1), solve(words, dp, i+1, p));
        }
        else{
            if(isPredecessor(words[p-1], words[i])){
                temp=Math.max(1+solve(words, dp, i+1, i+1), solve(words, dp, i+1, p));
            }
            else{
                temp=solve(words, dp, i+1, p);
            }
        }
        return dp[i][p]=temp;
    }
    public int longestStrChain(String[] words) {
        int n=words.length;
        Integer[][] dp=new Integer[n][n+1];

        Arrays.sort(words, (a,b)-> Integer.compare(a.length(), b.length()) );

        return solve(words, dp, 0, 0);
    }
}