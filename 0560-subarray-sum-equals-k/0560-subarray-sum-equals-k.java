class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        int sum=0, count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int diff=sum-k;
            if(hm.containsKey(diff)){
                count+=hm.get(diff);
            }
            if(0==diff){
                count++;
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }

        return count;
    }
}