class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        long ans=nums[0];
        
        if(nums.length==1) return nums[0];
        
        long p=nums[0], n=Long.MIN_VALUE/2, delp=Long.MIN_VALUE/2, deln=Long.MIN_VALUE/2;
        
        for(int i=1;i<nums.length;i++){
            long oldp=p, oldn=n;
            long t=nums[i];
            p=Math.max(oldn+t, t);
            n=oldp-t;

            long olddelp=delp, olddeln=deln;

            delp=Math.max(olddeln+t, oldp);
            deln=Math.max(olddelp-t, oldn);
            // System.out.println(p+" "+n+" "+delp+" "+deln);
            ans=Math.max(ans, Math.max(Math.max(p, n), Math.max(delp, deln)));
            
        }
        return ans;
    }
}