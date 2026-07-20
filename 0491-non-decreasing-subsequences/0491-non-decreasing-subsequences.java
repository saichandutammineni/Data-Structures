class Solution {
    private void findWays(int[] nums, int index, List<Integer> ll, Set<List<Integer>> res){
        if(index==nums.length){
            if(ll.size()>1){
                res.add(new ArrayList<>(ll));
            }

            return;
        }

        findWays(nums, index+1, ll, res);

        if((ll.size()>0 && ll.get(ll.size()-1)<=nums[index]) || ll.size()==0){
            ll.add(nums[index]);
            findWays(nums, index+1, ll, res);
            ll.remove(ll.size()-1);
        }
        
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        List<Integer> ll=new ArrayList<>();

        findWays(nums, 0, ll, res);
        return new ArrayList<>(res);
    }
}