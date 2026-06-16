class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=efficiency[i];
            arr[i][1]=speed[i];
        }

        Arrays.sort(arr, (a,b)-> b[0]-a[0]);
        long totalSpeed=0, ans=0;

        PriorityQueue<Integer> speedq=new PriorityQueue<>(k);
        for(int i=0;i<n;i++){
            if(speedq.size()==k){
                totalSpeed-=speedq.poll(); // min. speed among k in speedq
            }

            speedq.offer(arr[i][1]); // push speeds
            totalSpeed+=arr[i][1];

            ans=Math.max(ans, totalSpeed * arr[i][0]);
        }

        return (int)(ans%1000000007);

    }
}