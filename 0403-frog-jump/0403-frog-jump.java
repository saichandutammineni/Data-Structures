class Solution {
    private int solve(int curr, int last, Integer[][] dp, int[] stones, HashMap<Integer, Integer> hm){
        if(curr==stones.length-1) return 1;

        if(dp[last][curr]!=null) return dp[last][curr];

        int t=0;
        for(int i=last-1;i<=last+1;i++){
            if(i<=0) continue;
            if(hm.containsKey(stones[curr]+i)){
                int newIndex=hm.get(stones[curr]+i);
                t+=solve(newIndex, stones[newIndex]-stones[curr], dp, stones, hm);
            }
        }
        // for(int i=curr+1;i<stones.length;i++){
        //     if(stones[i]-stones[curr]>=last-1 && stones[i]-stones[curr]<=last+1)
        //     t+=solve(i, stones[i]-stones[curr], dp, stones);
        // }
        return dp[last][curr]= (t>0) ? 1: 0;
        
    }
    public boolean canCross(int[] stones) {
        int n=stones.length;
        Integer[][] dp=new Integer[n][n];
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(stones[i], i);
        }
        
        if(stones[1]>1) return false;
        
        return solve(1,1, dp, stones, hm)==1;
    }
}