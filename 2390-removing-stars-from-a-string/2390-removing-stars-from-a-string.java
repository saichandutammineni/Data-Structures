class Solution {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();

        int i=0;
        while(i<s.length()){
            char t=s.charAt(i++);
            if(t=='*'){
                sb.setLength(sb.length() - 1);
            }
            else{
                sb.append(t);
            }
        }
        return sb.toString();
    }
}