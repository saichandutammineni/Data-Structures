class Solution {
    // private boolean validate(StringBuilder sb){
    //     int max=0;
    //     if(sb.length()==4){
    //         max=11;
    //     }
    //     else{
    //         max=59;
    //     }

    //     int val=0;
    //     for(int i=sb.length()-1;i>=0;i--){
    //         if(sb.charAt(i)==1){
    //             val+=Math.pow(2, i);
    //         }
    //         if(val>max){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    private String getValue(StringBuilder sb, int t){
        // System.out.print(sb.toString());
        int val=0;
        int n=sb.length();
        for(int i=n-1;i>=0;i--){
            if(sb.charAt(i)=='1'){
                val+=Math.pow(2, n-i-1);
                t--;
            }
        }
        
        if(t==0){
        if(n==4){
            if(val<12 && val>=0){
                return String.valueOf(val);
            }
        }
        else{
            if(val<60 && val>=0){
                if(val<10){
                    return "0"+val;
                }
                else{
                    return ""+val;
                }
            }
            
        }
        }
        return "";
    }
    private void getCombs(StringBuilder sb, int t, int hm, List<String> hmin, int index){
        if(index==sb.length() || hm==0){
            String val=getValue(sb, t);
            if(val.length()>0)
                hmin.add(val);
            return;
        }

        sb.setCharAt(index, '1');
        // if(!validate(sb)){
        //     sb.setCharAt(index, '0');
        // }
        // else{
            getCombs(sb, t, hm-1, hmin, index+1);
            sb.setCharAt(index, '0');
        // }
        getCombs(sb,t, hm, hmin, index+1);
    }

    private void getTimes(List<String> res, int t, int h, int min, List<String> hours, List<String> minutes){
        getCombs(new StringBuilder("0000"), h, h, hours, 0);
        getCombs(new StringBuilder("000000"), min, min, minutes, 0);

        for(int i=0;i<hours.size();i++){
            for(int j=0;j<minutes.size();j++){
                res.add(hours.get(i)+":"+minutes.get(j));
            }
        }
    }
    public List<String> readBinaryWatch(int t) {
        List<String> res=new ArrayList<>();
        List<String> hours=new ArrayList<>();
        List<String> minutes=new ArrayList<>();
        if(t>8){
            return res;
        }
        // finding max value of hours allowed
        int m=Math.min(t,3);
        for(int i=0;i<=m;i++){
            getTimes(res, t, i, t-i, hours, minutes);
            hours.clear();
            minutes.clear();
        }
        
        return res;
    }
}