class Solution {
    public int trap(int[] height) {
        int[] minmax=new int[height.length];
        int max=0;
        for(int i=0;i<height.length;i++){
            max=Math.max(max, height[i]);
            minmax[i]=max;
        }
        max=height[height.length-1];
        for(int i=height.length-1;i>=0;i--){
            max=Math.max(max, height[i]);
            minmax[i]=Math.min(minmax[i], max);
        }
        max=0;
        for(int i=0;i<height.length;i++){
            max+=minmax[i]-height[i];
        }
        return max;
    }
}