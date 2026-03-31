class Solution {
    //HashMap<Integer, Integer> hm=new HashMap<>();
    List<Integer> cumulatedList=new ArrayList<>();
    int prefixSum=0;
    Random rand = new Random();
    private int findMapper(int target){
        int l=0, r=cumulatedList.size()-1;
        while(l<=r){
            int mid=(l+r)/2;
            if((mid==0 && cumulatedList.get(mid)>=target) || (cumulatedList.get(mid)>=target && cumulatedList.get(mid-1)<target)){
                return mid;
            }
            else if(cumulatedList.get(mid)<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return (l+r)/2;
    }
    public Solution(int[] w) {
        
        for(int i=0;i<w.length;i++){
            prefixSum+=w[i];
            //hm.put(prefixSum, i);
            //System.out.println(prefixSum+" "+i);
            cumulatedList.add(prefixSum);
        }
    }
    
    public int pickIndex() {
        if(cumulatedList.size()>0){
            int randomPickIndex=rand.nextInt(prefixSum)+1;
            return findMapper(randomPickIndex);
        }
        else{
            return 0;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */