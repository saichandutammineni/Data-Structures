class Solution {
    public int longestValidParentheses(String s) {
        ArrayDeque<Integer> st=new ArrayDeque<Integer>(); //stack

        st.push(-1);
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);

            }
            else{
                int lastStartIndex=st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    res=Math.max(res, i-st.peek());
                }
            }
        }
        return res;
    }
}