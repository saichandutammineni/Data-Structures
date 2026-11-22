class Pair{
    int c;
    int t;
    Pair(int c, int t){
        this.c=c;
        this.t=t;
    }
}
class Solution {
    private int solve(List<Pair> ll, Integer[][] dp, int index, int walls){
        if(walls<=0){
            return 0;
        }
        if(index==dp.length) return Integer.MAX_VALUE/2;

        if(dp[index][walls]!=null) return dp[index][walls];
            
        
        int free=solve(ll, dp, index+1, walls);

        int paid=ll.get(index).c+solve(ll, dp, index+1, walls-ll.get(index).t-1);

        return dp[index][walls]=Math.min(free, paid);
    }
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        Integer[][] dp=new Integer[n][n+1]; // [curr index][no.of walls to paint next]
        List<Pair> ll=new ArrayList<>();
        for(int i=0;i<n;i++){
            ll.add(new Pair(cost[i], time[i]));
        }
        // Collections.sort(ll, ((a,b)-> {
        //     if(a.c!=b.c)
        //     return Integer.compare(a.c, b.c);
        //     else
        //     return Integer.compare(b.t, a.t);
        // }));
        return solve(ll, dp, 0, n);
    }
}