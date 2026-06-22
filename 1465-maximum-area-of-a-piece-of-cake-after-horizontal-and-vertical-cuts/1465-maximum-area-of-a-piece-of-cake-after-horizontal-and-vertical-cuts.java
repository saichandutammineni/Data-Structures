class Solution {
    private int findMax(int[] arr, int n){
        // int[] freq=new int[100001];
        // for(int num: arr){
        //     freq[num]++;
        // }
        // int index=0;
        // for(int i=0;i<freq.length;i++){
        //     while(freq[i]-->0)
        //         arr[index++]=i;
        // }
        Arrays.sort(arr);
        

        int max=arr[0]-0;
        for(int i=1;i<arr.length;i++){
            max=Math.max(max, arr[i]-arr[i-1]);
        }
        return Math.max(max, n-arr[arr.length-1]);

    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod=1000000007;
        


        return (int)(((long)findMax(horizontalCuts, h)*(long)findMax(verticalCuts, w))%mod);
    }
}