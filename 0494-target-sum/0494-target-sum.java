class Solution {
    private void getWays(int[] nums, int target, List<List<Integer>> res, int index, int sum, List<Integer> ll){
        if(sum==target && index==nums.length){
            res.add(new ArrayList<>(ll));
            return;
        }
        else if(index==nums.length){
            return;
        }

        ll.add(index);
        getWays(nums, target, res, index+1, sum-(nums[index]), ll);
        ll.remove(ll.size()-1);
        getWays(nums, target, res, index+1, sum+nums[index], ll);
    }
    public int findTargetSumWays(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        getWays(nums, target, res, 0, 0, ll);
        return res.size();
    }
}