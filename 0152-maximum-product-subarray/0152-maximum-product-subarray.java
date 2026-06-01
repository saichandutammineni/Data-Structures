class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0], maxEnding=nums[0], minEnding=nums[0];

        for(int i=1;i<nums.length;i++){
            int num=nums[i];
            int b=maxEnding * num;
            int c=minEnding*num;
            
            maxEnding=Math.max(num, Math.max(b, c));
            minEnding=Math.min(num, Math.min(b, c));

            res=Math.max(res, maxEnding);
            
        }
        return res;
    }
}