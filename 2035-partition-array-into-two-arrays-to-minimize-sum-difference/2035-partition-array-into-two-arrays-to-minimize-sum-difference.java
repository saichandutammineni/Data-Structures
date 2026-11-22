class Solution {
    private void generate(int index, int end, int[] nums, List<List<Integer>> l, int count, int sum){
        if(index==end+1){
            l.get(count).add(sum);
            return;
        }

        generate(index+1, end, nums, l, count, sum);
        generate(index+1, end, nums, l, count+1, sum+nums[index]);
    }

    private int binaryS(int target, List<Integer> list){
        int l=0, r=list.size();
        // Collections.sort(list);

        while(l<r){
            int mid=l+(r-l)/2;
            if(list.get(mid)<target){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;

    }
    public int minimumDifference(int[] nums) {
        int totalsum=0;
        for(int i:nums)
            totalsum+=i;

        int n=nums.length/2;
        // int target=totalsum/2;
        

        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<=n;i++){
            l.add(new ArrayList<>());
        }
        generate(0, n-1, nums, l, 0, 0);
        List<List<Integer>> r=new ArrayList<>();
        for(int i=0;i<=n;i++){
            r.add(new ArrayList<>());
        }
        generate(n, 2*n-1, nums, r, 0, 0);

        for(int i=0;i<=n;i++){

            Collections.sort(r.get(i));
        }

        // int ans=Integer.MAX_VALUE;
        // for(int i=0;i<l.size();i++){
        //     for(int j: l.get(i)){
        //         ans=Math.min(ans, Math.abs(j-binaryS(totalsum-2*j, r.get(n-i))));
        //     }
        // }
        int ans = Integer.MAX_VALUE;

for (int i = 0; i <= n; i++) {
    for (int j : l.get(i)) {

        List<Integer> list = r.get(n-i);

        int target = (totalsum - 2*j) / 2;

        int idx = binaryS(target, list);

        if (idx < list.size()) {
            ans = Math.min(ans,
                Math.abs(totalsum - 2*(j + list.get(idx))));
        }

        if (idx > 0) {
            ans = Math.min(ans,
                Math.abs(totalsum - 2*(j + list.get(idx-1))));
        }
    }
}
        
        return ans;
    }
}