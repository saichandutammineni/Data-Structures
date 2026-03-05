class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder str=new StringBuilder(strs[0]);
        for(int i=1;i<strs.length;i++){
            int j=0;
            int len=Math.min(str.length(), strs[i].length());
            while(j<len && str.charAt(j)==strs[i].charAt(j)){
                j++;
            }
            
            if(j==0){
                return "";
            }
            str.setLength(j);
        }
        return str.toString();
    }
}