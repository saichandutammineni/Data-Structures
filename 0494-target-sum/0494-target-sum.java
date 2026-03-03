class Solution {
    private void getWays(int[] nums, int target, List<List<Integer>> res, int index, int sum, List<Integer> ll){
        
        if(sum==target && index==nums.length){
            res.add(new ArrayList<>(ll));
            return;
        }
        else if(index==nums.length){
            return;
        }

        // if(sum>target){
            ll.add(index);
            getWays(nums, target, res, index+1, sum-(2*nums[index]), ll);
            // if(ll.size()>0){
            ll.remove(ll.size()-1);
            // }
        // }
        getWays(nums, target, res, index+1, sum, ll);
        // if(ll.size()>0){
        //     ll.remove(ll.size()-1);
        // }
    }
    public int findTargetSumWays(int[] nums, int target) {
        // int sum=0, zeroCount=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0){
        //         zeroCount++;
        //     }
        //     else{
        //     sum+=nums[i];
        //     }
        // }
         int sum=0;
        for(int i=0;i<nums.length;i++){
           
            sum+=nums[i];
        }
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        getWays(nums, target, res, 0, sum, ll);
        return res.size();
        // return zeroCount>0 ? (int)Math.pow(2, zeroCount)* res.size(): res.size();
    }
}