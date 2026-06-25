class Solution {
    public int minimumSwap(String s1, String s2) {
        int countxy=0, countyx=0, ans=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i)=='x'){
                    countxy++;
                }
                else{
                    countyx++;
                }
            }
        }

        ans+=countxy/2;
        countxy=countxy%2;

        ans+=countyx/2;
        countyx=countyx%2;

        if(countxy!=countyx){
            return -1;
        }
        else if(countxy==0){
            return ans;
        }
        else{
            return ans+2;
        }
    }
}