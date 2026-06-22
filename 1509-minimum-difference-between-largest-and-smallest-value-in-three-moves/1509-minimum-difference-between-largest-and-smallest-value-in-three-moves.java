class Solution {
    public int minDifference(int[] nums) {
        int n=nums.length;
        if(n<=4) return 0;
        
        // finding smallest 4: a b c d .... w x y z
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,c=Integer.MAX_VALUE, d=Integer.MAX_VALUE;
        int x=Integer.MIN_VALUE,y=Integer.MIN_VALUE,z=Integer.MIN_VALUE, w=Integer.MIN_VALUE; // largest 4
        for(int num: nums){
            if(num<d){
                if(num<a){
                    d=c;
                    c=b;
                    b=a;
                    a=num;
                }
                else if(num<=b){
                    d=c;
                    c=b;
                    b=num;
                }
                else if(num<=c){
                    d=c;
                    c=num;
                }
                else{
                    d=num;
                }
            }

            if(num>w){
                if(num>z){
                    w=x;
                    x=y;
                    y=z;
                    z=num;
                }
                else if(num>y){
                    w=x;
                    x=y;
                    y=num;
                }
                else if(num>x){
                    w=x;
                    x=num;
                }
                else{
                    w=num;
                }
            }
        }
        // Arrays.sort(nums);

      //  return Math.min(Math.min(nums[n-1]-nums[3], nums[n-2]-nums[2]),
       // Math.min(nums[n-3]-nums[1], nums[n-4]-nums[0]));
    
       return Math.min(Math.min(z-d, y-c), Math.min(x-b, w-a));
    }
}