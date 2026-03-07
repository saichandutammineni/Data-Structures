class Solution {
    private void getStrings(List<String> res, StringBuilder str, int l, int r, int n){
        if(l==n && r==n){
            res.add(new String(str));
        }

        if(l<n){
            str.append("(");
            getStrings(res, str, l+1,r, n);
            str.deleteCharAt(str.length()-1);
        }
        if(l>r && r<n){
            str.append(")");
            getStrings(res, str, l,r+1, n);
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        getStrings(res, str, 0,0, n);
        return res;
    }
}