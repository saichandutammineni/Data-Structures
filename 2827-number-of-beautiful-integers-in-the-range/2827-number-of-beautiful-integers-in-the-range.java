class Solution {
    private int solve(int index, Integer[][][][][] dp, String s, boolean bound, int even, int odd, int rem, boolean allzero, int k){
        if(index==s.length()){
            return (odd==even && rem==0) ? 1 : 0;
        }

        if(dp[index][bound ? 1: 0][even][odd][rem]!=null){
            return dp[index][bound ? 1: 0][even][odd][rem];
        }

        int end=bound ? (s.charAt(index)-'0') : 9;
        int temp=0;
        for(int i=0;i<=end;i++){
            boolean newbound=bound && (i==end);
            boolean newallzero=allzero && (i==0);
            int newrem=(rem*10+i)%k;
            
            if(i%2==0){
                temp+=solve(index+1, dp, s, newbound, newallzero ? even : even+1, odd, newrem, newallzero, k);
            }
            else{
                temp+=solve(index+1, dp, s, newbound, even, odd+1, newrem, newallzero, k);
            }
        }

        return dp[index][bound ? 1: 0][even][odd][rem]=temp;
    }
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        String hist=high+"";
        String lost=(low-1)+""; 
        Integer[][][][][] dp=new Integer[hist.length()][2][hist.length()+1][hist.length()+1][k];
        Integer[][][][][] dp1=new Integer[lost.length()][2][lost.length()+1][lost.length()+1][k];

        return solve(0, dp, hist, true, 0, 0, 0, true, k)-solve(0, dp1, lost, true, 0,0,0,true, k);
    }
}