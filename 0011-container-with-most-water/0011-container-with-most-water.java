class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1, res=0;

        while(l<r){
            int max=Math.min(height[l], height[r]) * (r-l);
            if(max>res){
                res=max;
            }
            if(height[l]<= height[r]){
                l++;
            }
            else{
                r--;
            }
        }

        return res;
        
    }
}