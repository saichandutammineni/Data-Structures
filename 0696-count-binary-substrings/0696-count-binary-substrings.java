class Solution {
    public int countBinarySubstrings(String s) {
        int currRun=1, prev=0, res=0;
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                currRun++;
            }
            else{
                res+=Math.min(currRun, prev);
                prev=currRun;
                currRun=1;
            }
        }
        res+=Math.min(currRun, prev);
        return res;
    }
}