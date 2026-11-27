class Solution {
    
    private int solve(int vi, int index, int n){
        if(index==n){
            
                return 1;
            
        }
        int count=0;
        for(int i=vi;i<5;i++){
            count+=(solve(i, index+1, n));
        }
        return count;
    }
    public int countVowelStrings(int n) {
        
        return solve(0, 0, n);
    }
}