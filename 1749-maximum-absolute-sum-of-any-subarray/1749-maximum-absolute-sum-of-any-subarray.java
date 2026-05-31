class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxPrefix=0, minPrefix=0, prefix=0;

        for(int i:nums){
            prefix+=i;
            maxPrefix=Math.max(prefix, maxPrefix);
            minPrefix=Math.min(prefix, minPrefix);
        }
        return maxPrefix-minPrefix;
    }
}