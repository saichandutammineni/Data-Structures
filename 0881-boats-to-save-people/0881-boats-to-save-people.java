class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] freq=new int[limit+1];

        for(int i:people){
            freq[i]++;
        }

        int l=1,r=freq.length-1, count=0;
        while(l<=r){
            while(l<=r && freq[r]==0){
                r--;
            }
            while(l<=r && freq[l]==0){
                l++;
            }

            if(l==r){
                if(l+r<=limit){
                    count+=(freq[l]+1)/2;
                }
                else{
                    count+=freq[l];
                }
                l++;
            }
            else if(l+r<=limit){
                if(freq[l]<freq[r]){
                    freq[r]-=freq[l];
                    
                count+=freq[l];
                freq[l]=0;
                l++;
                }
                else{
                    count+=freq[r];
                    freq[l]-=freq[r];
                    freq[r]=0;
                r--;
                }

            }
            else{
                count+=freq[r];
                freq[r]=0;
                r--;
            }   
        }
        return count;
    }
}