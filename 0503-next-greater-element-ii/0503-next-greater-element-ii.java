class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n*2];
        
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
        }
        for(int i=n;i<arr.length;i++){
            arr[i]=nums[i-n];
        }
        int[] next=new int[n*2];
        ArrayDeque<Integer> st=new ArrayDeque<Integer>();
        st.push(-1);
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                next[i]=-1;
            }
            else{
                next[i]=st.peek();
            }

            st.push(arr[i]);
        }

        for(int i=0;i<next.length/2;i++){
            nums[i]=next[i];
        }
        return nums;
    }
}