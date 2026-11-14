class Solution {
    public int minMoves(int[] nums) {
        int ans=0, max=Integer.MIN_VALUE;
        for(int i:nums){
            max=Math.max(max , i);
        }

        for(int i:nums){
            ans+=max-i;
        }
        return ans;
    }
}