class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] freq=new int[10];
        int sum=0;
        for(int i:digits){
            freq[i]++;
            
        }

        for(int i=0;i<freq.length;i++){
            sum+=(i*freq[i]);
        }

        // remove elements to make sum 3 multiple
        if(sum%3!=0){

            boolean fix=false;
        if(sum%3==2){
            
            for(int i=2;i<9;i+=3){
                if(freq[i]>0){
                    freq[i]--;
                    fix=true;
                    break;
                }
            }
            if(!fix){
                int removedCount=0;
                for(int i=1;i<9;i+=3){
                while(freq[i]>0 && !fix){
                    freq[i]--;
                    if(removedCount==1){
                        fix=true;
                        break;
                    }
                    else{
                        removedCount++;
                    }
                    
                }
            }
            }
        }
        else if(sum%3==1){
            for(int i=1;i<9;i+=3){
                if(freq[i]>0){
                    freq[i]--;
                    fix=true;
                    break;
                }
            }
            if(!fix){
                int removedCount=0;
                for(int i=2;i<9;i+=3){
                while(freq[i]>0 && !fix){
                    freq[i]--;
                    if(removedCount==1){
                        fix=true;
                        break;
                    }
                    else{
                        removedCount++;
                    }
                    
                }
            }
            }
        }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=freq.length-1;i>=0;i--){
            while(freq[i]-->0){
                sb.append(i);
            }
        }

        if(sb.length()==0){
            return "";
        }
        else if(sb.charAt(0)=='0'){
            return "0";
        }
        return sb.toString();

    }
}