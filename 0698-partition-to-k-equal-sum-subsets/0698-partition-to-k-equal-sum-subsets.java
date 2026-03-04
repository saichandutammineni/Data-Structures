class Solution {
    private boolean getWays(int[] nums, boolean[] used, int start, int currSum, int target, int k){
        if(k==1){
            return true;
        }
        else if(currSum==target){
            return getWays(nums, used, 0, 0, target, k-1);
        }

        for(int i=start;i<nums.length;i++){
            if(used[i]) continue;
            if(currSum+nums[i] > target) continue;

            used[i]=true;
            if(getWays(nums, used, i+1, currSum+nums[i], target, k)){
                return true;
            }
            used[i]=false;

            if(currSum==0){
                break;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0, max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            sum+=nums[i];
        }
        int target=sum/k;
        if(sum%k!=0 || max>target){
            return false;
        }
        Arrays.sort(nums);
        int i=0, j=nums.length-1;
        while(i<j){
            int temp=nums[i];
            nums[i++]=nums[j];
            nums[j--]=temp;
        }
        boolean used[]=new boolean[nums.length];
        return getWays(nums, used, 0, 0, target, k);
    }
}