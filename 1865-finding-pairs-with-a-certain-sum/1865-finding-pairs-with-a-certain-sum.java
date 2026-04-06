class FindSumPairs {
    int[] arr1;
    int[] arr2;
    HashMap<Integer, Integer> hm=new HashMap<>();
    //int[] arr2Freq=new int[100001];

    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1=nums1;
        arr2=nums2;
        for(int i=0;i<nums2.length;i++){
            //arr2Freq[nums2[i]]++;
            hm.put(nums2[i], hm.getOrDefault(nums2[i], 0)+1);
        }
    }
    
    public void add(int index, int val) {
        if(hm.get(arr2[index])==1){
            hm.remove(arr2[index]);
        }
        else{
            hm.put(arr2[index], hm.getOrDefault(arr2[index], 0)-1);
        }
        
        // arr2Freq[arr2[index]]--;
        arr2[index]+=val;
        //arr2Freq[arr2[index]]++;
        hm.put(arr2[index], hm.getOrDefault(arr2[index], 0)+1);
    }
    
    public int count(int tot) {
        int count=0;
        for(int i=0;i<arr1.length;i++){
            int t=tot-arr1[i];
            if(t>0 && t<1000001 && hm.containsKey(t)){
                count+=hm.get(t);
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */