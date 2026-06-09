class Solution {
    public boolean find132pattern(int[] nums) {
        ArrayDeque<Integer> st=new ArrayDeque<Integer>();

        int n=nums.length, third=Integer.MIN_VALUE;
        st.push(nums[n-1]);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()<nums[i]){
                third=st.pop();
            }

            if(nums[i]<third){
                return true;
            }

            st.push(nums[i]);

        }
        return false;
    }
}