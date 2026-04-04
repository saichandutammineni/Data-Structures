class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1=0, c2=0, m1=0, m2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==c1){
                m1++;
            }
            else if(nums[i]==c2){
                m2++;
            }
            else if(m1==0){
                c1=nums[i];
                m1++;
            }
            else if(m2==0){
                c2=nums[i];
                m2++;
            }
            else{
                m1--;
                m2--;
            }
        }

        //verfification
        m1=0;
        m2=0;
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(c1==nums[i]){
                m1++;
            }
            else if(c2==nums[i]){
                m2++;
            }
        }
        if(m1>nums.length/3){
            res.add(c1);
        }
        if(m2>nums.length/3){
            res.add(c2);
        }
        return res;
    }
}