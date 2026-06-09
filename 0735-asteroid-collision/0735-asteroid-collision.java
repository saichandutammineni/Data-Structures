class Solution {
    public int[] asteroidCollision(int[] ast) {
        ArrayDeque<Integer> st=new ArrayDeque<Integer>();
        st.push(ast[0]);
        for(int i=1;i<ast.length;i++){
            boolean alive =true;

            while(!st.isEmpty() && alive && st.peek()>0 && ast[i]<0){
                //collision
                if(st.peek()<Math.abs(ast[i])){
                    st.pop();
                }
                else if(st.peek()==Math.abs(ast[i])){
                    st.pop();
                    alive=false;
                }
                else{
                    alive=false;
                }
            }

            if(alive){
                st.push(ast[i]);
            }
        }

        int[] res=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            res[i]=st.pop();
        }
        return res;
    }
}