class Solution {
    public int trap(int[] height) {
        int left_max=0, right_max=0, l=0, r=height.length-1, res=0;

        while(l<r){
            if(height[l]<height[r]){
                left_max=Math.max(left_max, height[l]);
                res+=left_max-height[l];
                l++;
            }
            else{
                right_max=Math.max(right_max, height[r]);
                res+=right_max-height[r];
                r--;
            }
        }
        return res;
    }
}