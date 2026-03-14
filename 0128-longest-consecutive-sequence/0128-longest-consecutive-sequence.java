class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<2) return nums.length;
        HashSet<Integer> hs=new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }
        int max=1;
        for(int num: hs){
            
            if(!hs.contains(num-1)){
                int currNum=num+1;
                while(hs.contains(currNum)){
                    currNum++;
                }
                if(currNum-num>max){
                    max=currNum-num;
                }
                // max=Math.max(max, currNum-num);
            }
            
        }

        return max;
    }
}