class Solution {

    private void findWays(List<List<Integer>> triangle, int[][] dp){
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=triangle.get(i).size()-1;j>=0;j--){
                int a=0, b=0;
                if(i+1<triangle.size()){
                    a=dp[i+1][j];
                    if(j+1<triangle.get(i+1).size()){
                        b=dp[i+1][j+1];
                    }
                }
                dp[i][j]=triangle.get(i).get(j)+Math.min(a,b);
            }
        }
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()+1][triangle.size()+1];
        findWays(triangle, dp);
        return dp[0][0];
    }
}