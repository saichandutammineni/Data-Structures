class Solution {

    private int solve(int[] nums, Integer[][] dp, int prev, int curr){
        if(curr==nums.length) return 0;
        if(dp[prev+1][curr]!=null) return dp[prev+1][curr];

        int temp=0;
        if(prev==-1){
        
            temp=solve(nums, dp, curr, curr+1)+1;
        }
        else if(nums[curr]%nums[prev]==0){
            temp=1+solve(nums, dp, curr, curr+1);
        }

        return dp[prev+1][curr]=Math.max(solve(nums, dp, prev, curr+1), temp);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Integer[][] dp=new Integer[n+1][n];

        Arrays.sort(nums);
        solve(nums, dp, -1, 0);
        List<Integer> res=new ArrayList<>();
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println(" ");
        // }
        
        int prev=-1;
        for(int curr=0;curr<nums.length;curr++){
            int skip=solve(nums, dp, prev, curr+1);

            if(prev==-1 || nums[curr]%nums[prev]==0){
                int take=1+solve(nums, dp, curr, curr+1);
                if(take>=skip){
                    res.add(nums[curr]);
                    prev=curr;
                }
            }
        }

        return res;
    }
}