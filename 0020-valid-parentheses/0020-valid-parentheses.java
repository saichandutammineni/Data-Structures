class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;
        
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            char t=s.charAt(i++);
            if(t=='(' || t=='{' || t=='['){
                sb.append(t);
            
            }
            else if(sb.length()==0){
                return false;
            }
            else{
                char r=sb.charAt(sb.length()-1);
                if((r=='(' && t==')') || (r=='{' && t=='}') || (r=='[' && t==']') ){
                    sb.deleteCharAt(sb.length()-1);
                }
                else{
                    return false;
                } 
            }
        }

        return sb.length()==0;
    }
}