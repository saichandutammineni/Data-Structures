class Solution {

    private void findWays(List<List<Integer>> triangle, int[][] dp){
        int n=triangle.size();
        for(int i=n-1;i>=0;i--){
            dp[1][i]=triangle.get(n-1).get(i);
        }



        for(int i=n-2;i>=0;i--){
            for(int j=triangle.get(i).size()-1;j>=0;j--){
                dp[0][j]=triangle.get(i).get(j)+Math.min(dp[1][j], dp[1][j+1]);
            }
            
            int t=0;
            for(int k: dp[0]){
                dp[1][t++]=k;
            }
        }
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[][] dp=new int[2][triangle.size()+1];
        findWays(triangle, dp);
        return dp[0][0];
    }
}