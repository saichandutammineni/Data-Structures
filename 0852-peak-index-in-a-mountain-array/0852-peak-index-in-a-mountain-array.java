class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l=1, r=arr.length-2;

        while(l<=r){
            int mid=l+(r-l)/2;
// (mid==0 && arr[mid]>arr[mid+1]) || (mid==arr.length-1 && arr[mid-1]<arr[mid]) || 
            if((arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1])){
                return mid;
            }
            else if(arr[mid]>arr[mid-1]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return 0;
    }
}