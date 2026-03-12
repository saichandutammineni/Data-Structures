class Solution {
    private void getPermutations(List<List<Integer>> res, List<Integer> ll,boolean[] used, int[] nums){
        if(ll.size()==nums.length){
            res.add(new ArrayList<>(ll));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]==false){
                used[i]=true;
                ll.add(nums[i]);
                getPermutations(res, ll, used, nums);
                ll.remove(ll.size()-1);
                used[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        getPermutations(res, ll, used, nums);
        return res;
    }
}