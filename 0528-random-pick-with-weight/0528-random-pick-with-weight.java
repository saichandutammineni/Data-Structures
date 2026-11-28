class Solution {
    List<Integer> ll=new ArrayList<>();
    Random rd=new Random();

    public Solution(int[] w) {
        int sum=0;
        
        for(int i:w){
            sum+=i;
            ll.add(sum);
        }
    }
    
    public int pickIndex() {
        int target=rd.nextInt(ll.get(ll.size()-1))+1;

        int l=0, r=ll.size();
        while(l<r){
            int mid=l+(r-l)/2;
            // if(ll.get(mid)==target || ((mid==0 || ll.get(mid-1)<target) && ll.get(mid)>=target)){
            //     break;
            // }
            if(ll.get(mid)>=target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */