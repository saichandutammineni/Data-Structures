class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr=new int[95];
        Arrays.fill(arr, -1);
        int i=0,j=0, max=0;
        for(j=0;j<s.length();j++){
            int x=s.charAt(j)-' ';
            // System.out.println(arr[x]);
            if(arr[x]<i){
        
                arr[x]=j;
            }
            else{
                max=Math.max(max, j-i);
                i=arr[x]+1;
                arr[x]=j;
            }
        }
        return Math.max(max, j-i);
    }
}