class Solution {
    private int solve(int[] arr, int k, int[] dp, int index){
        if(index>=arr.length) return 0;
        if(dp[index]!=-1){
            return dp[index];
        }

        int temp=0, curr_max=arr[index];
        for(int i=index;i<Math.min(arr.length, index+k);i++){
            curr_max=Math.max(arr[i], curr_max);
            temp=Math.max(temp, (curr_max*(i-index+1))+solve(arr, k, dp, i+1));
        }
        return dp[index]=temp;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length+1];
        Arrays.fill(dp, -1);
        return solve(arr, k, dp, 0);
    }
}