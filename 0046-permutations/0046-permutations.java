class Solution {
    private void swap(int[] nums, int i, int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
    private void getPermutations(List<List<Integer>> res, int index, int[] nums){
        if(index==nums.length){
            List<Integer> ll=new ArrayList<>();
            for(int num:nums){
                ll.add(num);
            }
            res.add(ll);
            return;
        }

        for(int i=index;i<nums.length;i++){
            swap(nums, index, i);
            getPermutations(res, index+1, nums);
            swap(nums, index , i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        
        getPermutations(res, 0, nums);
        return res;
    }
}