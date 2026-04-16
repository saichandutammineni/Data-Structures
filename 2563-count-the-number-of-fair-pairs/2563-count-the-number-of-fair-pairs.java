class Solution {
    private long countAtMost(int[] nums, int upper){
        int j=nums.length-1;
        long ans=0;

        for(int i=0;i<j;i++){

            while(i<j && nums[i]+nums[j]>upper){
                j--;
            }

            ans+=j-i;
        }
        return ans;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return countAtMost(nums, upper)-countAtMost(nums, lower-1);
    }
}