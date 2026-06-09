class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length, res=0;
        int[] prev=new int[n];
        ArrayDeque<Integer> st=new ArrayDeque<>();
        //st.push(-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                prev[i]=-1;
            }
            else{
                prev[i]=st.peek();
            }

            st.push(i);

        }

        st=new ArrayDeque<>();
        int[] next=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){ // >= to remove width from one side if equal heights like [2,2,2] 
                st.pop();
            }

            if(st.isEmpty()){
                next[i]=n;
            }
            else{
                next[i]=st.peek();
            }

            st.push(i);

        }


        for(int i=0;i<n;i++){
            res=Math.max(res, heights[i]*(next[i]-prev[i]-1));
        }
        return res;
    }
}