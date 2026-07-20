class Solution {
    int minFair=Integer.MAX_VALUE;
    

    private void findWays(int[] cookies, int k, int[] arr, int index){
        if(index==cookies.length){
            int tempMax=Integer.MIN_VALUE;
            for(int i=0;i<k;i++){
                if(tempMax<arr[i])
                    tempMax=arr[i];
            }
            if(minFair>tempMax){
                minFair=tempMax;
            }
            //System.out.println(minFair);
            
            return;
        }

        for(int i=0;i<k;i++){
            arr[i]+=cookies[index];
            findWays(cookies, k, arr, index+1);
            arr[i]-=cookies[index];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        int[] arr=new int[k];
        arr[0]=cookies[0];
        findWays(cookies, k, arr, 1);
        return minFair;
    }
}