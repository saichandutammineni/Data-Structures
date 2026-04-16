class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1, area=0;

        while(l<=r){

            if(height[l]<height[r]){
                area=Math.max(area, (height[l]*(r-l)));
                l++;
            }
            else{
                area=Math.max(area, (height[r]*(r-l)));
                r--;
            }
            
        }
        return area;
    }
}