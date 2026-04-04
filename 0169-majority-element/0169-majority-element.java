class Solution {
    public int majorityElement(int[] nums) {
        int candidate=nums[0], majority=1;
        for(int i=1;i<nums.length;i++){
            if(candidate==nums[i]){
                majority++;
            }
            else{
                if(majority==0){
                    candidate=nums[i];
                    majority++;
                }
                else{
                majority--;
                }
            }
        }

        return candidate;
    }
}