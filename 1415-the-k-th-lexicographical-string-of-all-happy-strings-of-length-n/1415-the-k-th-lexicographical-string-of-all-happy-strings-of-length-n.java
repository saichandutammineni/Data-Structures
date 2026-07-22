class Solution {

    private void findString(int n, int k, StringBuffer sb, int count){
        if(count==k) return;

        char[] arr={'a', 'b', 'c'};
        for(int i=0;i<arr.length;i++){
            if(sb.length()==0 || sb.charAt(sb.length()-1)!=arr[i]){
                if(count+Math.pow(2, n-sb.length()-1)<k){
                    count+=Math.pow(2, n-sb.length()-1);
                }
                else{
                    sb.append(arr[i]);
                    findString(n, k, sb, count);
                }
            }
        }
    }
    public String getHappyString(int n, int k) {
        if(3*Math.pow(2, n-1)<k) return "";
        StringBuffer sb=new StringBuffer();
        findString(n, k, sb, 0);
        return sb.toString();
    }
}